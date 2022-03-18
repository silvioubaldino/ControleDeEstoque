package com.erp.provider.entity;

import com.erp.person.entity.Person;

import javax.persistence.*;

@Entity
@Table(name = "provider")
public class Provider extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cnpj;
}
