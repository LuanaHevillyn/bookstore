package com.WDA.bookstore.repositories;

import com.WDA.bookstore.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByName(String name);

    Optional<User> findByEmail(String email);

    @Query("SELECT user FROM User user WHERE user.total_rents = (SELECT MAX(user.total_rents) FROM user)")
    List<User> findWhoRentsMore();
}
