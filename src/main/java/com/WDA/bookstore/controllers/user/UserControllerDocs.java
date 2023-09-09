package com.WDA.bookstore.controllers.user;

import com.WDA.bookstore.dtos.UserDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.parsing.Problem;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(tags = "Users")
@ApiResponses({@ApiResponse(code = 500, message = "There was an internal error", response = Problem.class)})
public interface UserControllerDocs {

    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "User created."),
            @ApiResponse(code = 400, message = "Missing data. Check and try again."),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })

    @PostMapping
    ResponseEntity<Void> create(@ApiParam(name = "body", value = "Representation of a new user", required = true) UserDTO request);

    @GetMapping
    ResponseEntity<?> findAll();

    @PutMapping
    ResponseEntity<Void> update(@PathVariable Long id, @RequestBody UserDTO user);

    @DeleteMapping
    ResponseEntity<Void> delete(Long id);
}
