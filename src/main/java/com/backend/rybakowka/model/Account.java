package com.backend.rybakowka.model;

import com.backend.rybakowka.dto.AccountDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    public Account(AccountDto account) {
        this.login = account.getLogin();
        this.password = new BCryptPasswordEncoder().encode(account.getPassword());
        this.firstname = account.getFirstname();
        this.lastname = account.getLastname();
        this.email = account.getEmail();
        this.phone = account.getPhone();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private String login;

    @NotNull
    private String password;

    @NotNull
    private String firstname;

    @NotNull
    private String lastname;

    @NotNull
    private String email;

    @NotNull
    private int phone;

////    @NotNull
//    private boolean confirmed;
//
//   // @NotNull
//    private boolean active;
//
//   // @NotNull
//    private boolean accessLevel;
//
//   // @NotNull
//    private Long accessLevelID;



    public AccountDto toDto() {
        return  AccountDto.builder()
                .login(this.login)
                .password(this.password)
                .firstname(this.firstname)
                .lastname(this.lastname)
                .email(this.email)
                .phone(this.phone)
                .build();
    }
}
