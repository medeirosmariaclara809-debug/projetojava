package br.com.alura.conversormoeda;

public record Moeda(String base_code, String target_code, double conversion_rate, double conversion_result) {
}
