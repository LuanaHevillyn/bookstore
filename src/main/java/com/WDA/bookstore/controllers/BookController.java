package com.WDA.bookstore.controllers;


import com.WDA.bookstore.controllers.docs.BookDocs;
import com.WDA.bookstore.dtos.BookDTO;
import com.WDA.bookstore.models.Book;
import com.WDA.bookstore.services.BookService;
import com.WDA.bookstore.utils.MapperBase;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    MapperBase mapperBase;

    @Autowired
    BookDocs bookDocs;

    @PostMapping({ "/create"})
    @ApiOperation(value = "Criar livro")
    public ResponseEntity<Object> createBook(@Valid @RequestBody BookDTO book) {
        Book bookModel = bookDocs.mapTo(book);
        Book savedBook = bookService.save (bookModel);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedBook.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @ApiOperation(value = "Listar livros")
    @GetMapping({ "/list" })
    // @formatter:off
    public ResponseEntity<?> indexBooks() {
        Type type = new TypeToken<List<BookDTO>>() {}.getType();

        List<BookDTO> result = mapperBase.toList(bookService.index(), type);
        return ResponseEntity.ok(result);

    }

    @ApiOperation(value = "Listar apenas um livro")
    @GetMapping({ "/list_id/{id}/"})
    public BookDTO showBook(@PathVariable("id") Long id) {
        return mapperBase.mapTo(bookService.show(id), BookDTO.class);
    }

    @PutMapping({ "/put/{id}/" })
    @ApiOperation(value = "Editar livro")
    public ResponseEntity<?> updateBook(
            @Min(value = 1) @PathVariable("id") Long id,
            @RequestBody BookDTO book) throws Exception {
        Book book1= bookDocs.mapTo(book);
        bookService.update(id, book1);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping({ "/delete/{id}/"})
    @ApiOperation(value = "Deletar livro")
    public ResponseEntity<?> deleteBook(@PathVariable("id") Long id) {
        bookService.delete(id);
        return ResponseEntity.ok().build();
    }

}
