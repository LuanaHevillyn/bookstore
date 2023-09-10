package com.WDA.bookstore.repositories;

import com.WDA.bookstore.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByName(String name);

    Optional<User> findByEmail(String email);

    @Modifying
    @Query("UPDATE User u SET u.total_rents = u.total_rents + 1 WHERE u.id = :userId")
    void addToTotalRents(@Param("userId") Long userId);
}
