package com.enigma.restservice.services.impl;

import com.enigma.restservice.entities.Unit;
import com.enigma.restservice.exceptions.EntityNotFoundException;
import com.enigma.restservice.repositories.UnitRepository;
import com.enigma.restservice.services.UnitService;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class UnitServiceImpl  extends CommonServiceImpl<Unit, Integer> implements UnitService {

    @Autowired
    private UnitRepository repository;

    @Override
    public Unit save(Unit entity) {
        return repository.save(entity);
    }

    @Override
    public Unit removeById(Integer id) {
        Unit entity = findById(id);
        repository.delete(entity);

        return entity;

    }

    @Override
    public Unit findById(Integer id) {
        return repository.findById(id).orElseThrow(() -> {
            return new EntityNotFoundException();
        });
    }

    @Override
    public Page<Unit> findAll(Unit entity, int page, int size, Sort.Direction direction) {
        Sort s = Sort.Direction.DESC.equals(direction) ? Sort.by("id").descending() : Sort.by("id");
        ExampleMatcher matcher = ExampleMatcher.matchingAll()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        return repository.findAll(Example.of(entity, matcher), PageRequest.of(page, size, s));
    }

    @Override
    protected JpaRepository<Unit, Integer> getRepository() {
        return repository;
    }
}
