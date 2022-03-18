package com.erp.address.entity;

import com.sun.istack.NotNull;

import javax.persistence.Embeddable;

//TODO
@Embeddable
public class Address {

    @NotNull
    private String logradouro;

    @NotNull
    private Integer numero;

    private String complemento;

    @NotNull
    private String bairro;

    private String cep;

    @NotNull
    private String cidade;
}
