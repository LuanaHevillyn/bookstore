package com.WDA.bookstore.publishers.repository;

import com.WDA.bookstore.publishers.entity.Publishers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublishersRepository extends JpaRepository<Publishers, Long> {
}
