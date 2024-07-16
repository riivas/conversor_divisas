package com.alurachallenge.conexiones;

import com.alurachallenge.records.DatosMoneda;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class ConversionDivisas {

    private DatosMoneda datosMoneda;

    public DatosMoneda convertorDivisas(String divisaOrigen, String divisaDestino){
         URI direccionDivisas = URI.create("https://v6.exchangerate-api.com/v6/cbd606884e68f5139d91a741/pair/"
                + divisaOrigen + "/" + divisaDestino);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccionDivisas)
                .build();

        try{
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return new Gson().fromJson(response.body(), DatosMoneda.class);
        }catch (Exception e) {
            throw new RuntimeException("No encontre el tipo de datosMoneda.");
        }
    }

    public double cambioDivisa(String monedaOrigen, String monedaDestino, double monto){
        if (monedaOrigen.equals(monedaDestino)){
            return monto;
        }

        Map<String, Double> divisas = convertorDivisas(monedaOrigen, monedaOrigen).conversion_rates();
        double origen = divisas.getOrDefault(monedaOrigen, 1.0);
        double destino = divisas.getOrDefault(monedaDestino, 1.0);

        return (monto/origen) * destino;

    }
}
