package com.alurachallenge.conexiones;

import com.alurachallenge.records.DivisasDisponibles;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class  ListaDivisas{
    public DivisasDisponibles listaDivisas(){
        URI direccionListas = URI.create("https://v6.exchangerate-api.com/v6/cbd606884e68f5139d91a741/codes");
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccionListas)
                .build();

        try{
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return new Gson().fromJson(response.body(), DivisasDisponibles.class);
        }catch (Exception e){
            throw new RuntimeException("No se encontró ninguna divisa.");
        }

    }

}
