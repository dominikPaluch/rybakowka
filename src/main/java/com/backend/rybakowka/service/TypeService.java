package com.backend.rybakowka.service;

import com.backend.rybakowka.dto.TypeDto;

import java.util.List;

public interface TypeService {

    List<TypeDto> getListOfTypes();

    TypeDto findTypeById(Long id);

    TypeDto add(TypeDto typeDto);

    TypeDto update(TypeDto typeDto);

    TypeDto delete(TypeDto typeDto);
}
