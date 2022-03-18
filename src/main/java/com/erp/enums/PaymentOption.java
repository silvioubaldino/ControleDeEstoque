package com.erp.enums;

public enum PaymentOption {

    ESPECIE ("em espécie"),
    PIX ("pix"),
    BOLETO ("boleto"),
    DEBITO ("cartão de débito"),
    CREDITO ("cartão de crédito");

    private String name;

    PaymentOption(String name) {
        this.name = name;
    }

    private enum Instalments{
        AVISTA ("a vista", "1x"),
        DUAS ("duas parcelas", "2x"),
        TRES ("três parcelas", "3x");

        private String name;
        private String abbreviation;

        Instalments(String name, String abbreviation) {
            this.name = name;
            this.abbreviation = abbreviation;
        }
    }
}
