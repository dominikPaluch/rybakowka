package com.backend.rybakowka.model;

import com.backend.rybakowka.dto.AccessLevelDto;
import com.backend.rybakowka.dto.AccountDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class AccessLevel {

    public AccessLevel(AccessLevelDto accessLevelDto) {
        this.name = accessLevelDto.getName();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
}
