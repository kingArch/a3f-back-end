package com.a3f.building.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.a3f.building.dtos.RequestDto;
import com.a3f.building.entities.RequestEntity;
import com.a3f.building.entities.RequestRepository;
import com.a3f.building.mappers.AbstractMapper;

@RestController
@CrossOrigin
public class BuildingController {

    @Autowired
    private RequestRepository repository;

    @Autowired
    @Qualifier("requestMapper")
    private AbstractMapper<RequestEntity, RequestDto> mapper;

    @GetMapping("/request")
    public List<RequestDto> getAll() {
        return repository.findAll().stream().map(entity -> mapper.entityToDto(entity)).collect(Collectors.toList());
    }

    @GetMapping("/request/{id}")
    public RequestDto get(@PathVariable final String id) {
        return mapper.entityToDto(repository.findById(id).get());
    }

    @PostMapping("/request")
    public RequestDto create(@RequestBody final RequestDto request) {
        return mapper.entityToDto(repository.save(mapper.dtoToEntity(request)));
    }

    @DeleteMapping("/request/{id}")
    public void delete(@PathVariable final String id) {
        repository.deleteById(id);
    }

    @DeleteMapping("/requests")
    public void deleteAll() {
        repository.deleteAll();
    }
}
