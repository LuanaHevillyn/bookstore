package com.WDA.bookstore.repositories;

import com.WDA.bookstore.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    boolean existsByPublisherIdAndName(Long editoraId, String nomeLivro);

    @Modifying
    @Query("UPDATE Book book SET book.total_leased = book.total_leased + 1, amount = amount - 1  WHERE book.id = :bookId")
    void addToTotalLeased(@Param("bookId") Long bookId);

}
