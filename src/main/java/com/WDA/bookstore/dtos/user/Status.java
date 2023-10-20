package com.WDA.bookstore.dtos.user;

import lombok.Getter;
import lombok.Setter;

@Getter
public enum Status {

    PENDENTE("Pendente"),

    DEVOLVIDO("Devolvido"),

    ATRASADO("Atrasado");

    private final String Status;

    Status(String status) {
        this.Status = status;
    }

    public String getStatus() {
        return Status;
    }
}
