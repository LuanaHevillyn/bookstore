package com.WDA.bookstore.services;


import com.WDA.bookstore.models.Book;
import com.WDA.bookstore.repositories.BookRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class BookService {

    final BookRepository bookRepository;

    public List<Book> index() {
        return bookRepository.findAll();
    }

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Transactional
    public Book save(Book book){
        return bookRepository.save( book );
    }

    public Book show(Long id) {
        return bookRepository.getReferenceById ( id );
    }


    public void delete(Long id) {
        bookRepository.deleteById(id);
    }

    public Book update(Long id,Book newBook) throws Exception {
        Book book = bookRepository.getReferenceById ( id );
        if (book == null) {
            throw new Exception();
        }
        if (book.getId() != id) {
            throw new IllegalArgumentException();
        }

        newBook.setId(id);
        Book bookDB = bookRepository.save(newBook);
        return bookDB;
    }


}
