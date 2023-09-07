package com.WDA.bookstore.services;

import com.WDA.bookstore.models.Book;
import com.WDA.bookstore.models.Publisher;
import com.WDA.bookstore.models.Rent;
import com.WDA.bookstore.repositories.BookRepository;
import com.WDA.bookstore.repositories.PublisherRepository;
import com.WDA.bookstore.repositories.RentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RentService {

    final RentRepository rentRepository;

    public List<Rent> index() {
        return rentRepository.findAll();
    }

    public RentService(RentRepository rentRepository) {
        this.rentRepository = rentRepository;
    }

    public Rent create(Rent rent){
        rent.setStatus ( "Pendente" );
        return rentRepository.save( rent );
    }

    public Rent show(Long id) {
        return rentRepository.getReferenceById ( id );
    }

    public void delete(Long id) {
        rentRepository.deleteById(id);
    }

    public Rent update(Long id, Rent rentEdited) {

        rentEdited.setId(id);
        return rentRepository.save(rentEdited);
    }
}
