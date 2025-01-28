package com.example;


public class Calculadora {

    private double primerNumero = 0;
    private String operador = "";

    public void establecerPrimerNumero(double numero) {
        this.primerNumero = numero;
    }

    public void establecerOperador(String operador) {
        this.operador = operador;
    }

    public double calcular(double segundoNumero) {
        switch (operador) {
            case "+": return primerNumero + segundoNumero;
            case "-": return primerNumero - segundoNumero;
            case "*": return primerNumero * segundoNumero;
            case "/": return segundoNumero != 0 ? primerNumero / segundoNumero : 0;
            default: return 0;
        }
    }
}
