package com.WDA.bookstore.services.rent;

import com.WDA.bookstore.dtos.book.BookGetDTO;
import com.WDA.bookstore.dtos.rent.RentGetDTO;
import com.WDA.bookstore.exceptions.book.AmountCantBeLessThanTheOldValueException;
import com.WDA.bookstore.exceptions.book.BookDoesntExistException;
import com.WDA.bookstore.exceptions.rent.RentCantBeDeletedException;
import com.WDA.bookstore.exceptions.rent.RentDoesntExistException;
import com.WDA.bookstore.exceptions.user.UserDoesntExistException;
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
import java.util.Optional;

@Service
@Transactional
public class RentServiceImpl implements RentService{

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

    public List<Rent> findAll() {
        return mapperBase.toList(rentRepository.findAll(), new TypeToken<List<RentGetDTO>>() {
        }.getType());
    }

    public RentGetDTO findById(Long id) {
        return rentRepository.findById(id)
                .map(rent -> mapperBase.mapTo(rent, RentGetDTO.class))
                .orElseThrow(() -> new RentDoesntExistException());
    }


    public void create(Rent rent) {
        rentEntityValidator.validateForCreate(rent);
        createRentInformation(rent);
    }

    public void delete(Long id) {
        throw new RentCantBeDeletedException();
    }

    public void update(Rent rent) {
        rentEntityValidator.validateForUpdate(rent);
        comparingDates(rent);
        updateRentInformation(rent);
        rentRepository.save(rent);
    }

    private void createRentInformation(Rent rent) {
        rent.setRentDate(LocalDate.now());
        rent.setStatus("Pendente");
        rentRepository.save(rent);

        Optional<User> userOptional = userRepository.findById(rent.getUser().getId());
        Optional<Book> bookOptional = bookRepository.findById(rent.getBook().getId());
        if (userOptional.isPresent() && bookOptional.isPresent()){
            Book book = bookOptional.get();
            User user = userOptional.get();
            book.setTotalLeased(book.getTotalLeased() + 1);
            book.setAmount(book.getAmount() - 1);
            user.setTotalRents(user.getTotalRents() + 1);
        }else if (userOptional.isEmpty()){
            throw new UserDoesntExistException();
        }else{
            throw new BookDoesntExistException();
        }
    }

    private void comparingDates(Rent rent) {
        Optional<Rent> rentOptional = rentRepository.findById(rent.getId());
        if (rentOptional.isPresent()) {
            Rent existingRent = rentOptional.get();
            LocalDate returnDate = rent.getReturnDate();
            LocalDate forecastDate = existingRent.getForecastDate();

            if (returnDate.isBefore(forecastDate) || returnDate.isEqual(forecastDate)) {
                rent.setStatus("Devolvido");
            } else {
                rent.setStatus("Atrasado");
            }
            rent.setRentDate(existingRent.getRentDate());
            rent.setForecastDate(existingRent.getForecastDate());
        }else {
            throw new RentDoesntExistException();
        }
    }

    private void updateRentInformation(Rent rent) {
        rentRepository.save(rent);

        Optional<User> userOptional = userRepository.findById(rent.getUser().getId());
        Optional<Book> bookOptional = bookRepository.findById(rent.getBook().getId());
        if (userOptional.isPresent() && bookOptional.isPresent()){
            Book book = bookOptional.get();
            User user = userOptional.get();
            book.setTotalLeased(book.getTotalLeased() - 1);
            book.setAmount(book.getAmount() + 1);
            user.setTotalRents(user.getTotalRents() - 1);
        }else if (userOptional.isEmpty()){
            throw new UserDoesntExistException();
        }else{
            throw new BookDoesntExistException();
        }
    }
}
