package br.com.alura.conversormoeda;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConversorApp {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        Conversor conversor = new Conversor();

        int opcao = 0;
        while (opcao != 7) {
            System.out.println("*************************************************");
            System.out.println("");
            System.out.println("Seja bem-vindo/a ao Conversor de Moeda =]");
            System.out.println("");
            System.out.println("1) Dólar =>> Peso argentino");
            System.out.println("2) Peso argentino =>> Dólar");
            System.out.println("3) Dólar =>> Real brasileiro");
            System.out.println("4) Real brasileiro =>> Dólar");
            System.out.println("5) Dólar =>> Peso colombiano");
            System.out.println("6) Peso colombiano =>> Dólar");
            System.out.println("7) Sair");
            System.out.println("Escolha uma opção válida:");
            System.out.println("*************************************************");
            System.out.println("");

            try {
                opcao = leitura.nextInt();
                
                if (opcao == 7) {
                    System.out.println("Saindo do programa...");
                    break;
                }

                String moedaBase = "";
                String moedaAlvo = "";

                switch (opcao) {
                    case 1:
                        moedaBase = "USD";
                        moedaAlvo = "ARS";
                        break;
                    case 2:
                        moedaBase = "ARS";
                        moedaAlvo = "USD";
                        break;
                    case 3:
                        moedaBase = "USD";
                        moedaAlvo = "BRL";
                        break;
                    case 4:
                        moedaBase = "BRL";
                        moedaAlvo = "USD";
                        break;
                    case 5:
                        moedaBase = "USD";
                        moedaAlvo = "COP";
                        break;
                    case 6:
                        moedaBase = "COP";
                        moedaAlvo = "USD";
                        break;
                    default:
                        System.out.println("Opção inválida! Tente novamente.\n");
                        continue;
                }

                if (!moedaBase.isEmpty()) {
                    System.out.println("Digite o valor que deseja converter:");
                    double valor = leitura.nextDouble();

                    Moeda moeda = conversor.converterMoeda(moedaBase, moedaAlvo, valor);
                    System.out.printf("Valor %.2f [%s] corresponde ao valor final de =>>> %.2f [%s]\n\n", 
                                      valor, moedaBase, moeda.conversion_result(), moedaAlvo);
                }
                                  
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Por favor, digite um número válido.\n");
                leitura.nextLine(); // limpar o buffer
            } catch (RuntimeException e) {
                System.out.println("Erro: " + e.getMessage() + "\n");
            }
        }
        leitura.close();
    }
}
