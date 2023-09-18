package com.WDA.bookstore.services;

import com.WDA.bookstore.dtos.RentDTO;
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

    public List<RentDTO> findAll() {
        return mapperBase.toList(rentRepository.findAll(), new TypeToken<List<RentDTO>>() {
        }.getType());
    }

    public Rent create(Rent rent) {
        rent.setStatus("Pendente");
        Book book = rent.getBook();
        User user = rent.getUser();

        if(book != null && user != null) {
            bookRepository.save(book);
            userRepository.save(user);
            rentRepository.save(rent);
        }
        return rent;
    }

    public void delete(Long id) {
        rentRepository.deleteById(id);
    }

    public Rent update(Long id, Rent rent) {
        rent.setId(id);
        LocalDate return_Date = rent.getReturn_date();
        LocalDate forecast_date = rent.getForecast_date();
        if(return_Date.isBefore(forecast_date)) {
            rent.setStatus("Devolvido");
        } else {
            rent.setStatus("Atrasado");
        }
        return rentRepository.save(rent);
    }

}
