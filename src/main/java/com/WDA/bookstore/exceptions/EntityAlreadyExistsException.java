package com.WDA.bookstore.exceptions.entityExists;

import com.WDA.bookstore.exceptions.ExceptionHandler;import javax.persistence.EntityExistsException;

public class EntityAlreadyExistsException extends EntityExistsException {
    public EntityAlreadyExistsException(String message) {
        super(message);
    }

    public static class PublisherAlreadyRelatedException extends ExceptionHandler.EntityAlreadyExistsException {
        public PublisherAlreadyRelatedException() {
            super("A editora já foi relacionada a este livro!");
        }
    }

    public static class PublisherNameAlredyExistsException extends ExceptionHandler.EntityAlreadyExistsException {
        public PublisherNameAlredyExistsException() {
            super("Uma editora já existe com esse nome!");
        }
    }

    public static class UserEmailAlredyExistsException extends ExceptionHandler.EntityAlreadyExistsException {
        public UserEmailAlredyExistsException() {
            super("O e-mail já foi relacionado a algum usuário!");
        }
    }

    public static class UserNameAlredyExistsException extends ExceptionHandler.EntityAlreadyExistsException {
        public UserNameAlredyExistsException() {
            super("O nome já foi relacionado a algum usuário!");
        }
    }

}
