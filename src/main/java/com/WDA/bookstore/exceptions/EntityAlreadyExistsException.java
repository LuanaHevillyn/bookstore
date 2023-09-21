package com.WDA.bookstore.exceptions;

import javax.persistence.EntityExistsException;

public class EntityAlreadyExistsException extends EntityExistsException {
    public EntityAlreadyExistsException(String message) {
        super(message);
    }

    public static class PublisherAlreadyRelatedException extends EntityAlreadyExistsException {
        public PublisherAlreadyRelatedException() {
            super("A editora já foi relacionada a este livro!");
        }
    }

    public static class PublisherNameAlredyExistsException extends EntityAlreadyExistsException {
        public PublisherNameAlredyExistsException() {
            super("Uma editora já existe com esse nome!");
        }
    }

    public static class UserEmailAlredyExistsException extends EntityAlreadyExistsException {
        public UserEmailAlredyExistsException() {
            super("O e-mail já foi relacionado a algum usuário!");
        }
    }

    public static class UserNameAlredyExistsException extends EntityAlreadyExistsException {
        public UserNameAlredyExistsException() {
            super("O nome já foi relacionado a algum usuário!");
        }
    }

}
