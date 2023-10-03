package com.WDA.bookstore.repositories;

import com.WDA.bookstore.models.Book;
import com.WDA.bookstore.models.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    boolean existsByPublisherAndName(Publisher publisher, String bookName);

    @Query("SELECT book FROM Book book WHERE book.totalLeased = (SELECT MAX(book.totalLeased) FROM book)")
    List<Book> findMostRented();

    @Query("SELECT book FROM Book book WHERE book.totalLeased > 5")
    List<Book> findListOfMostRented();

    @Query("SELECT book FROM Book book WHERE book.amount > 0")
    List<Book> findListOfAvaliable();
}
