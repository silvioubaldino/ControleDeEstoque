package com.erp.person.entity;

import com.erp.address.entity.Address;

import javax.persistence.Embedded;

public class Person {

    private String name;

    private String cpf;

    private String phone;

    private String email;

    @Embedded
    private Address address;
}
