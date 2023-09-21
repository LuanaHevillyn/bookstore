package com.WDA.bookstore.exceptions;

public class CantDeleteException extends RuntimeException {

    public CantDeleteException(String message) {
        super(message);
    }

    public static class PublisherCantBeDeleted extends CantDeleteException {
        public PublisherCantBeDeleted() {
            super("A editora não pode ser deletada pois possui livros relacionados a ela!");
        }
    }

    public static class BookCantBeDeleted extends CantDeleteException {
        public BookCantBeDeleted() {
            super("O livro não pode ser deletado pois possui aluguéis!");
        }
    }

    public static class UserCantBeDeleted extends CantDeleteException {
        public UserCantBeDeleted() {
            super("O usuário não pode ser deletado pois possui aluguéis!");
        }
    }

    public static class RentCantBeDeleted extends CantDeleteException {
        public RentCantBeDeleted() {
            super("O aluguel não pode ser deletado pois não foi devolvido!");
        }
    }
}
