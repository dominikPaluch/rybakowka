package com.backend.rybakowka.conrtoller;

import com.backend.rybakowka.dto.TypeDto;
import com.backend.rybakowka.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
//@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/types")
public class TypeController {

    private TypeService typeService;

    @Autowired
    public TypeController(TypeService typeService) {
        this.typeService = typeService;
    }

    //    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public List<TypeDto> getListOfTypes() {
        return typeService.getListOfTypes();
    }

    @GetMapping(value = "/{id}")
    public TypeDto findTypeById(@PathVariable Long id) {
        return typeService.findTypeById(id);
    }

    @PostMapping()
    public @ResponseBody
    TypeDto add(@RequestBody @Valid TypeDto typeDto) {
        typeService.add(typeDto);

        return typeDto;
    }

    @PutMapping(value = "/update/{id}")
    public @ResponseBody
    TypeDto update(@PathVariable("id") Long id, @RequestBody TypeDto typeDto) {
        typeService.update(typeDto);
        return typeDto;
    }

    @PutMapping(value = "/delete/{id}")
    public @ResponseBody
    TypeDto delete(@PathVariable("id") Long id, @RequestBody TypeDto typeDto) {
        typeService.delete(typeDto);
        return typeDto;
    }
}
