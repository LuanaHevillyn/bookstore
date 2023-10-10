package com.WDA.bookstore.controllers.book;


import com.WDA.bookstore.dtos.book.BookCreateDTO;
import com.WDA.bookstore.dtos.book.BookGetDTO;
import com.WDA.bookstore.dtos.book.BookUpdateDTO;
import com.WDA.bookstore.mappers.BookMapper;
import com.WDA.bookstore.models.Book;
import com.WDA.bookstore.services.book.BookService;
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
    public ResponseEntity<Void> create(@RequestBody @Valid BookCreateDTO book) {
        bookService.create(bookMapper.mapTo(book));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    @Override
    public ResponseEntity<List<Book>> findAll() {
        return new ResponseEntity<>(bookService.findAll(), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    @Override
    public BookGetDTO findById(Long id) {
        return bookService.findById(id);
    }

    @GetMapping("most-rented")
    @Override
    public ResponseEntity<List<Book>> mostRented() {
        return new ResponseEntity<>(bookService.mostRented(), HttpStatus.OK);
    }

    @GetMapping("list-of-most-rented")
    @Override
    public ResponseEntity<List<Book>> listOfMostRented() {
        return new ResponseEntity<>(bookService.listOfMostRented(), HttpStatus.OK);
    }

    @GetMapping("list-of-available")
    @Override
    public ResponseEntity<List<Book>> listOfAvailable() {
        return new ResponseEntity<>(bookService.listOfAvailable(), HttpStatus.OK);
    }

    @PutMapping
    @Override
    public ResponseEntity<Void> update(@RequestBody @Valid BookUpdateDTO book) {
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