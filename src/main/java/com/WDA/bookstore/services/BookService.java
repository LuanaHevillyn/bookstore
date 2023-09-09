package com.WDA.bookstore.services;

import com.WDA.bookstore.dtos.BookDTO;
import com.WDA.bookstore.exceptions.bookException.LaunchYearItsNotValid;
import com.WDA.bookstore.exceptions.bookException.PublisherAlreadyRelatedException;
import com.WDA.bookstore.models.Book;
import com.WDA.bookstore.repositories.BookRepository;
import com.WDA.bookstore.utils.MapperBase;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private MapperBase mapperBase;

    public List<BookDTO> findAll() {
        return mapperBase.toList(bookRepository.findAll(), new TypeToken<List<BookDTO>>() {
        }.getType());
    }

    public Book create(Book book) {
        if(publisherAlreadyRelated(book.getPublisher().getId(), book.getName())) {
            throw new PublisherAlreadyRelatedException();
        } else if(currentYearIsSmallerThanLaunchYear(book.getLaunch())) {
            return bookRepository.save(book);
        } else {
            throw new LaunchYearItsNotValid();
        }
    }

    public Book update(Long id, Book book) {
        book.setId(id);
        if(publisherAlreadyRelated(book.getPublisher().getId(), book.getName())) {
            throw new PublisherAlreadyRelatedException();
        } else if(currentYearIsSmallerThanLaunchYear(book.getLaunch())) {
            return bookRepository.save(book);
        } else {
            throw new LaunchYearItsNotValid();
        }
    }

    public void delete(Long id) {
        bookRepository.deleteById(id);
    }

    public boolean currentYearIsSmallerThanLaunchYear(Integer launchYear) {
        int currentYear = LocalDate.now().getYear();
        return launchYear <= currentYear;
    }

    public boolean publisherAlreadyRelated(Long editoraId, String nomeLivro) {
        return bookRepository.existsByPublisherIdAndName(editoraId, nomeLivro);
    }
}
