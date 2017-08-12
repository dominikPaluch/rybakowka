package com.backend.rybakowka.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {

    @NotNull
    private String login;

    @NotNull
    private String password;

    @NotNull
    private String firstname;

    @NotNull
    private String lastname;

    @NotNull
    private String email;
    //
    @NotNull
    private int phone;

    //    @NotNull
    private boolean confirmed;

    //    @NotNull
    private boolean active;

    //    @NotNull
    private boolean accessLevel;

    //    @NotNull
    private Long accessLevelID;
}
