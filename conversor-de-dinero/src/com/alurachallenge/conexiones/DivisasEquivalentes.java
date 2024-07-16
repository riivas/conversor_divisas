package com.alurachallenge.conexiones;

import com.alurachallenge.records.DatosMoneda;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class DivisasEquivalentes {
    public DatosMoneda moneda(String divisa){
        URI direccionDivisas = URI.create("https://v6.exchangerate-api.com/v6/cbd606884e68f5139d91a741/latest/" + divisa);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccionDivisas)
                .build();


        try{
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return new Gson().fromJson(response.body(), DatosMoneda.class);
        }catch (Exception e){
            throw new RuntimeException("No se encontró el tipo de moneda.");
        }

    }

}
