package com.erp.enums;

public enum Size {

    P("Pequeno", "P"),
    M("Médio", "M"),
    G("Grande", "G"),
    GG("Muito grande", "GG");

    private String size;
    private String initials;

    Size(String size, String initials) {
        this.size = size;
        this.initials = initials;
    }
}
