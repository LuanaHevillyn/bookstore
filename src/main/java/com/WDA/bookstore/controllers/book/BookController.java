package com.WDA.bookstore.controllers.book;


import com.WDA.bookstore.dtos.BookDTO;
import com.WDA.bookstore.mappers.BookMapper;
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
    public ResponseEntity<Void> create(@RequestBody @Valid BookDTO book) {
        bookService.create(bookMapper.mapTo(book));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    @Override
    public ResponseEntity<List<BookDTO>> findAll() {
        return new ResponseEntity<>(bookService.findAll(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody BookDTO book) {
        bookService.update(id, bookMapper.mapTo(book));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        bookService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}