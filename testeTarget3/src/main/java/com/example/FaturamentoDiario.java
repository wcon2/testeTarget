package com.example;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FaturamentoDiario {

    private int dia;
    private double valor;

    public FaturamentoDiario(int dia, double valor) {
        this.dia = dia;
        this.valor = valor;
    }

    public int getDia() {
        return dia;
    }

    public double getValor() {
        return valor;
    }

    public static void main(String[] args) {

        String filePath = "C:/Users/Aluno/Documents/testetarget/dados.json";
        Gson gson = new Gson();
        FaturamentoDiario[] faturamentoDiario;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            faturamentoDiario = gson.fromJson(br, FaturamentoDiario[].class);

            double mediaMensal = 0;
            double somaFaturamento = 0;
            double menorValor = faturamentoDiario[0].getValor();
            double maiorValor = faturamentoDiario[0].getValor();
            int qtdDiasAcimaDaMedia = 0;

            for (FaturamentoDiario dia : faturamentoDiario) {
                somaFaturamento += dia.getValor();

                if (dia.getValor() < menorValor) {
                    menorValor = dia.getValor();
                }

                if (dia.getValor() > maiorValor) {
                    maiorValor = dia.getValor();
                }
            }

            mediaMensal = somaFaturamento / faturamentoDiario.length;

            for (FaturamentoDiario dia : faturamentoDiario) {
                if (dia.getValor() > mediaMensal) {
                    qtdDiasAcimaDaMedia++;
                }
            }

            System.out.println("Menor valor de faturamento diário: " + menorValor);
            System.out.println("Maior valor de faturamento diário: " + maiorValor);
            System.out
                    .println("Número de dias no mês em que o valor de faturamento diário foi superior à média mensal: "
                            + qtdDiasAcimaDaMedia);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}