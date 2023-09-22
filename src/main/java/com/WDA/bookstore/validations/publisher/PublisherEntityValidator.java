package com.WDA.bookstore.validations.publisher;

import com.WDA.bookstore.models.Publisher;

public interface PublisherEntityValidator {

    void validateForCreate(Publisher publisher);

    void validateForUpdate(Publisher publisher);

    void validateForDelete(Long id);
}
