package com.backend.rybakowka.dto;

import com.backend.rybakowka.model.AccessLevelEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

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
}