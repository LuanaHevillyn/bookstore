package com.WDA.bookstore.repositories;

import com.WDA.bookstore.models.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Long> {
    boolean existsByName(String name);

    @Query("SELECT publisher FROM Publisher publisher WHERE publisher.related_books = (SELECT MAX(publisher.related_books) FROM publisher)")
    List<Publisher> findMostUsed();
}
