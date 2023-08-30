package com.WDA.bookstore.users.repository;

import com.WDA.bookstore.users.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
}
