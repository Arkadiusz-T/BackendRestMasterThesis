package com.tokarskia.BackendMagisterka.model;

public class Response {
    final double czasPobieraniaTekstowZBazyDanych;

    final String czasPrzeslaniaRequestuZFrontuDoBackendu;
    final String czasWystawieniaOdpowiedziDlaFrontendu;


    public Response(double czasPobraniaTekstowZBazyDanych, String czasPrzeslaniaRequestuZFrontuDoBackendu, String czasWystawieniaOdpowiedziDlaFrontendu) {
        this.czasPobieraniaTekstowZBazyDanych = czasPobraniaTekstowZBazyDanych;
        this.czasPrzeslaniaRequestuZFrontuDoBackendu = czasPrzeslaniaRequestuZFrontuDoBackendu;
        this.czasWystawieniaOdpowiedziDlaFrontendu = czasWystawieniaOdpowiedziDlaFrontendu;
    }

    public double getCzasPobieraniaTekstowZBazyDanych() {
        return czasPobieraniaTekstowZBazyDanych;
    }

    public String getCzasPrzeslaniaRequestuZFrontuDoBackendu() {
        return czasPrzeslaniaRequestuZFrontuDoBackendu;
    }

    public String getCzasWystawieniaOdpowiedziDlaFrontendu() {
        return czasWystawieniaOdpowiedziDlaFrontendu;
    }

}
