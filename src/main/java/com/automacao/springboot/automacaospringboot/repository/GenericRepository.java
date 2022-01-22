package com.automacao.springboot.automacaospringboot.repository;


import com.automacao.springboot.automacaospringboot.model.GenericModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface GenericRepository <T extends GenericModel> extends JpaRepository<T, Serializable> {


}
