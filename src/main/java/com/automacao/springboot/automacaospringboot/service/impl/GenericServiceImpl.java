package com.automacao.springboot.automacaospringboot.service.impl;

import com.automacao.springboot.automacaospringboot.model.GenericModel;
import com.automacao.springboot.automacaospringboot.repository.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class GenericServiceImpl<T extends GenericModel>{

    @Autowired
    private GenericRepository<T> genericRepository;

    public List<T> list() {
        return genericRepository.findAll();
    }


    public T create(@RequestBody T entity) {
        return genericRepository.save(entity);
    }


    public T update(@PathVariable(value = "id") long id, @RequestBody T entity) {
        return genericRepository.save(entity);
    }


    public void delete(@PathVariable(value = "id") long id) {
        genericRepository.deleteById(id);

    }

    public T get(@PathVariable(value = "id") long id) {
        return genericRepository.getOne(id);
    }

}
