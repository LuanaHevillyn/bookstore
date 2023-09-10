package com.WDA.bookstore.repositories;

import com.WDA.bookstore.models.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Long> {
    Optional<Publisher> findByName(String name);

    @Modifying
    @Query("UPDATE Publisher publisher SET publisher.related_books = publisher.related_books + 1 WHERE publisher.id = :publisherId")
    void addToRelatedBooks(@Param("publisherId") Long publisherId);
}
