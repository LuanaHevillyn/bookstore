package com.WDA.bookstore.repositories;

import com.WDA.bookstore.models.Book;
import com.WDA.bookstore.models.Rent;
import com.WDA.bookstore.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RentRepository extends JpaRepository<Rent, Long> {
    boolean existsByBook(Book book);

    boolean existsByUser(User user);

    boolean existsByBookAndUserAndStatus(Optional<Book> bookOptional, Optional<User> userOptional, String status);
}
