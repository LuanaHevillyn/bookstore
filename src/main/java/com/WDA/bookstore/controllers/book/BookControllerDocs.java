package com.WDA.bookstore.controllers.book;

import com.WDA.bookstore.dtos.inputs.BookInput;
import com.WDA.bookstore.models.Book;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.parsing.Problem;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Books")
@ApiResponses({@ApiResponse(code = 500, message = "There was an internal error", response = Problem.class)})
public interface BookControllerDocs {

    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Book created."),
            @ApiResponse(code = 400, message = "Missing data. Check and try again."),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })

    @PostMapping
    ResponseEntity<Void> create(@ApiParam(name = "body", value = "Representation of a new book", required = true) BookInput request);

    @GetMapping
    ResponseEntity<?> findAll();

    @GetMapping("most-rented")
    ResponseEntity<List<Book>> mostRented();

    @GetMapping("list-of-most-rented")
    ResponseEntity<List<Book>> listOfMostRented();

    @GetMapping("list-of-available")
    ResponseEntity<List<Book>> listOfAvailable();

    @PutMapping
    ResponseEntity<Void> update(@RequestBody BookInput book);


    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id);
}
