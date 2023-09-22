package com.WDA.bookstore.services;

import com.WDA.bookstore.dtos.outputs.RentOutput;
import com.WDA.bookstore.models.Book;
import com.WDA.bookstore.models.Rent;
import com.WDA.bookstore.models.User;
import com.WDA.bookstore.repositories.BookRepository;
import com.WDA.bookstore.repositories.RentRepository;
import com.WDA.bookstore.repositories.UserRepository;
import com.WDA.bookstore.utils.MapperBase;
import com.WDA.bookstore.validations.rent.RentEntityValidator;
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
    private RentEntityValidator rentEntityValidator;

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
        rentEntityValidator.validateForCreate(rent);
        Book book = rent.getBook();
        User user = rent.getUser();
        createRentInformation(rent, book, user);
    }

    public void delete(Long id) {
        rentRepository.deleteById(id);
    }

    public void update(Rent rent) {
        comparingDates(rent);
        updateRentInformation(rent);
        rentRepository.save(rent);
    }

    private void createRentInformation(Rent rent, Book book, User user) {
        rent.setRentDate(LocalDate.now());
        rent.setStatus("Pendente");
        rentRepository.save(rent);

        book.setTotalLeased(book.getTotalLeased() + 1);
        book.setAmount(book.getAmount() - 1);
        user.setTotalRents(user.getTotalRents() + 1);
        bookRepository.save(book);
        userRepository.save(user);
    }

    private void comparingDates(Rent rent) {
        LocalDate returnDate = rent.getReturnDate();
        LocalDate forecastDate = rent.getForecastDate();

        if(returnDate.isBefore(forecastDate) || returnDate.isEqual(forecastDate)) {
            rent.setStatus("Devolvido");
        } else {
            rent.setStatus("Atrasado");
        }
    }

    private void updateRentInformation(Rent rent) {
        Book book = rent.getBook();
        User user = rent.getUser();

        rentRepository.save(rent);
        book.setTotalLeased(book.getTotalLeased() - 1);
        book.setAmount(book.getAmount() + 1);
        user.setTotalRents(user.getTotalRents() - 1);
        bookRepository.save(book);
        userRepository.save(user);
    }
}
