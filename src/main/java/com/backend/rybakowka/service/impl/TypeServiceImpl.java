package com.backend.rybakowka.service.impl;

import com.backend.rybakowka.dto.TypeDto;
import com.backend.rybakowka.exception.TypeException;
import com.backend.rybakowka.model.Type;
import com.backend.rybakowka.repository.TypeRepository;
import com.backend.rybakowka.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TypeServiceImpl implements TypeService {

    private TypeRepository typeRepository;

    @Autowired
    public  TypeServiceImpl(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }
    @Override
    public List<TypeDto> getListOfTypes() {
        return typeRepository.findAll().stream()
                .map(Type::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public TypeDto findTypeById(Long id) {
        return Optional.ofNullable(typeRepository.findOne(id))
                .orElseThrow(
                        () -> new TypeException("Type doesn't exixts!"))
                .toDto();
    }

    @Override
    public TypeDto add(TypeDto typeDto) {
        Type type = new Type(typeDto);
        return typeRepository.saveAndFlush(type).toDto();
    }

    @Override
    public TypeDto update(TypeDto typeDto) {
        Type type = new Type(findTypeById(typeDto.getId()));

        type.setName(typeDto.getName());
        type.setDescription(typeDto.getDescription());
        type.setNormalPrice(typeDto.getNormalPrice());
        type.setSeasonPrice(typeDto.getSeasonPrice());

        return typeRepository.save(type).toDto();
    }

    @Override
    public TypeDto delete(TypeDto typeDto) {
        Type type = new Type(findTypeById(typeDto.getId()));

        type.setDeleted(true);
        return typeRepository.save(type).toDto();
    }
}
