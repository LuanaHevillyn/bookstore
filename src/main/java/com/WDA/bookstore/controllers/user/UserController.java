package com.WDA.bookstore.controllers.user;

import com.WDA.bookstore.dtos.UserDTO;
import com.WDA.bookstore.mappers.UserMapper;
import com.WDA.bookstore.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController implements UserControllerDocs {

    @Autowired
    private UserService userService;

    @Autowired
    UserMapper userMapper;

    @PostMapping
    @Override
    public ResponseEntity<Void> create(@RequestBody @Valid UserDTO user) {
        userService.create(userMapper.mapTo(user));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    @Override
    public ResponseEntity<List<UserDTO>> findAll() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody UserDTO user) {
        userService.update(id, userMapper.mapTo(user));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Void> delete(Long id) {
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
