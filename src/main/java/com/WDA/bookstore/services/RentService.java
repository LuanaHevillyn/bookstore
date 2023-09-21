package com.WDA.bookstore.services;

import com.WDA.bookstore.dtos.outputs.RentOutput;
import com.WDA.bookstore.exceptions.CantDeleteException;
import com.WDA.bookstore.exceptions.illegalArgumentException;
import com.WDA.bookstore.models.Book;
import com.WDA.bookstore.models.Rent;
import com.WDA.bookstore.models.User;
import com.WDA.bookstore.repositories.BookRepository;
import com.WDA.bookstore.repositories.RentRepository;
import com.WDA.bookstore.repositories.UserRepository;
import com.WDA.bookstore.utils.MapperBase;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class RentService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RentRepository rentRepository;

    @Autowired
    private MapperBase mapperBase;

    public List<RentOutput> findAll() {
        return mapperBase.toList(rentRepository.findAll(), new TypeToken<List<RentOutput>>() {
        }.getType());
    }

    public void create(Rent rent) {
        Book book = rent.getBook();
        User user = rent.getUser();

        if(canRentBook(book, user)) {
            createRentInformation(rent, book, user);
        } else {
            throw new illegalArgumentException.AmountIsZero();
        }
    }

    public void delete(Long id) {
        Rent rent = rentRepository.findById(id).get();
        if(rent.getReturn_date() == null) {
            throw new CantDeleteException.RentCantBeDeleted();
        } else {
            rentRepository.deleteById(id);
        }
    }

    @Transactional
    public void update(Rent rent) {
        rent.getId();
        comparingDates(rent);
        updateRentInformation(rent);
        rentRepository.save(rent);
    }

    private boolean canRentBook(Book book, User user) {
        return book != null && user != null && book.getAmount() > 0;
    }

    private void createRentInformation(Rent rent, Book book, User user) {
        rent.setRent_date(LocalDate.now());
        rent.setStatus("Pendente");
        rentRepository.save(rent);

        book.setTotal_leased(book.getTotal_leased() + 1);
        book.setAmount(book.getAmount() - 1);
        user.setTotal_rents(user.getTotal_rents() + 1);
        bookRepository.save(book);
        userRepository.save(user);
    }

    private void comparingDates(Rent rent) {
        LocalDate return_Date = rent.getReturn_date();
        LocalDate forecast_date = rent.getForecast_date();

        if(return_Date.isBefore(forecast_date)) {
            rent.setStatus("Devolvido");
        } else {
            rent.setStatus("Atrasado");
        }
    }

    private void updateRentInformation(Rent rent) {
        Book book = rent.getBook();
        User user = rent.getUser();

        rentRepository.save(rent);
        book.setTotal_leased(book.getTotal_leased() - 1);
        book.setAmount(book.getAmount() + 1);
        user.setTotal_rents(user.getTotal_rents() - 1);
        bookRepository.save(book);
        userRepository.save(user);
    }
}
