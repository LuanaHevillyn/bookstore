package com.WDA.bookstore.users.builder;

import com.WDA.bookstore.users.dto.UsersDTO;
import lombok.Builder;

import javax.persistence.Column;

@Builder
public class UsersDTOBuilder {

    @Builder.Default
    private final Long id = 1L;

    @Builder.Default
    private final String name = "Luana Hevillyn";

    @Builder.Default
    private final String city = "Cidade das Maravilhas";

    @Builder.Default
    private final String email = "Luanahevillynn@gmail.com";

    @Builder.Default
    private final String address = "Rua 58";

    public UsersDTO buildUsersDTO(){
        return new UsersDTO(id, name, city, email, address);
    }
}
