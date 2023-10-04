package com.WDA.bookstore.repositories;

import com.WDA.bookstore.models.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Long> {
    boolean existsByNameAndIdNot(String name, Long id);

    @Query("SELECT publisher FROM Publisher publisher WHERE publisher.relatedBooks = (SELECT MAX(publisher.relatedBooks) FROM publisher)")
    List<Publisher> findMostUsed();

    boolean existsById(Long id);
}
