package com.WDA.bookstore.controllers.book;


import com.WDA.bookstore.dtos.inputs.BookInput;
import com.WDA.bookstore.dtos.outputs.BookOutput;
import com.WDA.bookstore.mappers.BookMapper;
import com.WDA.bookstore.models.Book;
import com.WDA.bookstore.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookController implements BookControllerDocs {

    @Autowired
    private BookService bookService;

    @Autowired
    BookMapper bookMapper;

    @PostMapping
    @Override
    public ResponseEntity<Void> create(@RequestBody @Valid BookInput book) {
        bookService.create(bookMapper.mapTo(book));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    @Override
    public ResponseEntity<List<BookOutput>> findAll() {
        return new ResponseEntity<>(bookService.findAll(), HttpStatus.OK);
    }

    @GetMapping("mostRented")
    @Override
    public ResponseEntity<List<Book>> MostRented() {
        return new ResponseEntity<>(bookService.MostRented(), HttpStatus.OK);
    }

    @GetMapping("listOfMostRented")
    @Override
    public ResponseEntity<List<Book>> ListOfMostRented() {
        return new ResponseEntity<>(bookService.ListOfMostRented(), HttpStatus.OK);
    }

    @PutMapping
    @Override
    public ResponseEntity<Void> update(@RequestBody BookInput book) {
        bookService.update(bookMapper.mapTo(book));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        bookService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}