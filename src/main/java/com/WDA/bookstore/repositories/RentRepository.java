package com.WDA.bookstore.repositories;

import com.WDA.bookstore.models.Rent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RentRepository extends JpaRepository<Rent, Long> {
}