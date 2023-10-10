package com.WDA.bookstore.controllers.user;

import com.WDA.bookstore.dtos.user.UserCreateDTO;
import com.WDA.bookstore.dtos.user.UserGetDTO;
import com.WDA.bookstore.dtos.user.UserUpdateDTO;
import com.WDA.bookstore.models.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.parsing.Problem;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "Users")
@ApiResponses({@ApiResponse(code = 500, message = "There was an internal error", response = Problem.class)})
public interface UserControllerDocs {

    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "User created."),
            @ApiResponse(code = 400, message = "Missing data. Check and try again."),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })

    @PostMapping
    ResponseEntity<Void> create(@ApiParam(name = "body", value = "Representation of a new user", required = true) UserCreateDTO request);


    @GetMapping("who-rents-more")
    ResponseEntity<List<User>> whoRentsMore();

    @GetMapping
    ResponseEntity<?> findAll();

    @GetMapping("/{id}")
    UserGetDTO findById(Long id);

    @PutMapping
    ResponseEntity<Void> update(@RequestBody @Valid UserUpdateDTO user);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id);
}
