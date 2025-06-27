package com.book.booksstore.service;

import com.book.booksstore.dto.ShoppingCartResponseDto;
import com.book.booksstore.exception.EntityNotFoundException;
import com.book.booksstore.mappers.ShoppingCartMapper;
import com.book.booksstore.model.Book;
import com.book.booksstore.model.CartItem;
import com.book.booksstore.model.ShoppingCart;
import com.book.booksstore.model.User;
import com.book.booksstore.repository.BookRepository;
import com.book.booksstore.repository.CartItemRepository;
import com.book.booksstore.repository.ShoppingCartRepository;
import com.book.booksstore.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SoppingCartServiceImpl implements ShoppingCartService {
    private final ShoppingCartRepository shoppingCartRepository;
    private final ShoppingCartMapper shoppingCartMapper;
    private final CartItemRepository itemRepository;
    private final UserDetailsService userDetailsService;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    @Override
    @Transactional(readOnly = true)
    public ShoppingCartResponseDto getShoppingCart(Long cartId) {
        ShoppingCart cart = shoppingCartRepository.findById(cartId)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Cart not found: " + cartId));
        return shoppingCartMapper.toDto(cart);
    }

    @Override
    @Transactional
    public ShoppingCartResponseDto addBook(Long bookId, int quantity) {
        User user = resolveCurrentUser();
        ShoppingCart cart = shoppingCartRepository
                .findFirstByUserAndIsDeletedFalse(user);
        if (cart == null) {
            cart = new ShoppingCart();
            cart.setUser(user);
            cart = shoppingCartRepository.save(cart);
        }

        CartItem item = cart.getCartItems().stream()
                .filter(cartItemRepository -> cartItemRepository
                        .getBook()
                        .getId()
                        .equals(bookId))
                .findFirst()
                .orElseGet(() -> {
                    CartItem cartItem = new CartItem();
                    Book book = bookRepository.findById(bookId)
                            .orElseThrow(() -> new EntityNotFoundException(
                                    "Book not found: " + bookId));
                    cartItem.setBook(book);

                    return cartItem;
                });

        item.setQuantity(item.getQuantity() + quantity);
        itemRepository.save(item);

        return shoppingCartMapper.toDto(cart);
    }

    @Override
    @Transactional
    public ShoppingCartResponseDto updateItemQuantity(
            Long cartItemId,
            int quantity) {
        CartItem item = itemRepository.findById(cartItemId)
                .orElseThrow(() -> new EntityNotFoundException(
                        "CartItem not found: " + cartItemId));

        ShoppingCart cart = item.getShoppingCart();
        if (quantity <= 0) {
            cart.getCartItems().remove(item);
            itemRepository.delete(item);
        } else {
            item.setQuantity(quantity);
            itemRepository.save(item);
        }
        return shoppingCartMapper.toDto(cart);
    }

    @Override
    public void createShoppingCart(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException(
                        "User not found: " + userId));
        ShoppingCart existing = shoppingCartRepository
                .findFirstByUserAndIsDeletedFalse(user);
        if (existing != null) {
            shoppingCartMapper.toDto(existing);
            return;
        }
        ShoppingCart cart = new ShoppingCart();
        cart.setUser(user);
        cart = shoppingCartRepository.save(cart);

        shoppingCartMapper.toDto(cart);
    }

    @Override
    @Transactional
    public ShoppingCartResponseDto deleteItemFromShoppingCart(Long cartItemId) {
        User user = resolveCurrentUser();
        ShoppingCart cart = shoppingCartRepository
                .findFirstByUserAndIsDeletedFalse(user);
        if (cart == null) {
            return shoppingCartMapper.toDto(new ShoppingCart());
        }

        boolean removed = cart.getCartItems().removeIf(cartItem ->
                cartItem.getId().equals(cartItemId)
        );

        if (removed) {
            shoppingCartRepository.save(cart);
        }

        return shoppingCartMapper.toDto(cart);
    }

    private User resolveCurrentUser() {
        String username = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();

        UserDetails userDetails = userDetailsService
                .loadUserByUsername(username);
        return userRepository.findByEmail(userDetails.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException(
                        "User not found: " + userDetails.getUsername()));
    }
}
