package com.WDA.bookstore.repositories;

import com.WDA.bookstore.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByNameAndIdNot(String name, Long id);

    boolean existsByEmailAndIdNot(String email, Long id);

    @Query("SELECT user FROM User user WHERE user.totalRents = (SELECT MAX(user.totalRents) FROM user)")
    List<User> findWhoRentsMore();
}
