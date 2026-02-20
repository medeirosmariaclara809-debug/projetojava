package br.com.alura.conversormoeda;

import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conversor {
    
    private static final String API_KEY = "fee63e0fe1c6971414d95a23";

    public Moeda converterMoeda(String moedaBase, String moedaAlvo, double valor) {
        URI endereco = URI.create("https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/" + moedaBase + "/" + moedaAlvo + "/" + valor);
        
        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();
        
        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Moeda.class);
        } catch (Exception e) {
            throw new RuntimeException("Não foi possível realizar a conversão. Verifique os dados e tente novamente.");
        }
    }
}