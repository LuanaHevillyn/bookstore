package com.WDA.bookstore.repositories;

import com.WDA.bookstore.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    boolean existsByPublisherIdAndName(Long editoraId, String nomeLivro);
}
