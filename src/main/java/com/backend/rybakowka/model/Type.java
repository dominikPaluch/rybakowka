package com.backend.rybakowka.model;

import com.backend.rybakowka.dto.TypeDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Type {

    public Type(TypeDto typeDto) {
        this.name = typeDto.getName();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String  name;

    public TypeDto toDto() {
        return  TypeDto.builder()
                .name(this.name)
                .build();
    }
}
