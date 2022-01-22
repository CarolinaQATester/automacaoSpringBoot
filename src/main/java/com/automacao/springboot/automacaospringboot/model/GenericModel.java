package com.automacao.springboot.automacaospringboot.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@SuppressWarnings("serial")
@MappedSuperclass
public class GenericModel implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false, columnDefinition = "BIGINT")
    private long id;
}