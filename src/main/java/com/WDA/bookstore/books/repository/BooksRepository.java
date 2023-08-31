package com.WDA.bookstore.books.repository;

import com.WDA.bookstore.books.entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<Books, Long> {
}
