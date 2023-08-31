package com.WDA.bookstore.rents.repository;

import com.WDA.bookstore.rents.entity.Rents;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentsRepository extends JpaRepository<Rents, Long> {
}
