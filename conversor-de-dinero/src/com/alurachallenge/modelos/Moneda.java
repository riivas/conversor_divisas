package com.alurachallenge.modelos;

import com.alurachallenge.records.DatosMoneda;

public class Moneda {

    private String codigoDivisa;

    private String nombreDivisa;

    private Double tasaDeConversion;

    private DatosMoneda datosMoneda;

    public Moneda(){}



    public String getCodigoDivisa() {
        return codigoDivisa;
    }

    public void setCodigoDivisa(String codigoDivisa) {
        this.codigoDivisa = codigoDivisa;
    }

    public String getNombreDivisa() {
        return nombreDivisa;
    }

    public void setNombreDivisa(String nombreDivisa) {
        this.nombreDivisa = nombreDivisa;
    }

    public Double getTasaDeConversion() {
        return tasaDeConversion;
    }

    public void setTasaDeConversion(Double tasaDeConversion) {
        this.tasaDeConversion = tasaDeConversion;
    }

    public DatosMoneda getDatosMoneda() {
        return datosMoneda;
    }

    public void setDatosMoneda(DatosMoneda datosMoneda) {
        this.datosMoneda = datosMoneda;
    }

}
