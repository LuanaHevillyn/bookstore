package com.WDA.bookstore.validations.book;

import com.WDA.bookstore.dtos.book.BookCreateDTO;
import com.WDA.bookstore.models.Book;

public interface BookEntityValidator {

    void validateForCreate(Book book);

    void validateForUpdate(Book book);

    void validateForDelete(Long id);
}
