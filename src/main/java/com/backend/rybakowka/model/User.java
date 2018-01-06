package com.backend.rybakowka.model;

import com.backend.rybakowka.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    public User(UserDto userDto) {
        this.id = userDto.getId();
        this.login = userDto.getLogin();
        this.password = userDto.getPassword();
//        this.password = new BCryptPasswordEncoder().encode(userDto.getPassword());
        this.firstname = userDto.getFirstname();
        this.lastname = userDto.getLastname();
        this.email = userDto.getEmail();
        this.isConfirmed = userDto.isConfirmed();
        this.isDeleted = userDto.isDeleted();
        this.phone = userDto.getPhone();
        this.accessLevelEnum = userDto.getAccessLevelEnum();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(unique = true)
    private String login;

    @NotNull
    private String password;

    @NotNull
    private String firstname;

    @NotNull
    private String lastname;

    @NotNull
    @Column(unique = true)
    private String email;

    @NotNull
    private int phone;

    @NotNull
    private boolean isConfirmed;

    @NotNull
    private boolean isDeleted;

    @NotNull
    private AccessLevelEnum accessLevelEnum;

    public UserDto toDto() {
        return UserDto.builder()
                .id(this.id)
                .login(this.login)
                .password(this.password)
                .firstname(this.firstname)
                .lastname(this.lastname)
                .email(this.email)
                .phone(this.phone)
                .isConfirmed(this.isConfirmed)
                .isDeleted(this.isDeleted)
                .accessLevelEnum(this.accessLevelEnum)
                .build();
    }
}
