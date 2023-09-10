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
    @Query("UPDATE Book b SET b.total_leased = b.total_leased + 1 WHERE b.id = :bookId")
    void addToTotalLeased(@Param("bookId") Long bookId);

}
