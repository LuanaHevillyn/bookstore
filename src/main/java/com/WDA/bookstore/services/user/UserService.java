package com.WDA.bookstore.services.user;

import com.WDA.bookstore.models.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

     List<User> findAll();

     List<User> whoRentsMore();

     void create(User user);

     void update(User user);

     void delete(Long id);
}
