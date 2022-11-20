package com.tokarskia.BackendMagisterka.model;

public class Response {
    final double czasPobieraniaTekstowZBazyDanych;
    final Long czasPrzeslaniaRequestuZFrontuDoBackendu;
    final String czasWystawieniaOdpowiedziDlaFrontendu;
    final Double podobienstwoTextow;


    public Response(Long czasPobraniaTekstowZBazyDanych, Long czasPrzeslaniaRequestuZFrontuDoBackendu, String czasWystawieniaOdpowiedziDlaFrontendu, Double podobienstwoTextow) {
        this.czasPobieraniaTekstowZBazyDanych = czasPobraniaTekstowZBazyDanych;
        this.czasPrzeslaniaRequestuZFrontuDoBackendu = czasPrzeslaniaRequestuZFrontuDoBackendu;
        this.czasWystawieniaOdpowiedziDlaFrontendu = czasWystawieniaOdpowiedziDlaFrontendu;
        this.podobienstwoTextow = podobienstwoTextow;
    }

    public double getCzasPobieraniaTekstowZBazyDanych() {
        return czasPobieraniaTekstowZBazyDanych;
    }

    public Long getCzasPrzeslaniaRequestuZFrontuDoBackendu() {
        return czasPrzeslaniaRequestuZFrontuDoBackendu;
    }

    public String getCzasWystawieniaOdpowiedziDlaFrontendu() {
        return czasWystawieniaOdpowiedziDlaFrontendu;
    }

    public Double getPodobienstwoTextow() {
        return podobienstwoTextow;
    }
}
