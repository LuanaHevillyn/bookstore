package com.WDA.bookstore.repositories;

import com.WDA.bookstore.models.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PublishersRepository extends JpaRepository<Publisher, UUID> {
}
