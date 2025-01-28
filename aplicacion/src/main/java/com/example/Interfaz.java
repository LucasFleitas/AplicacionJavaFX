package com.example;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Interfaz {

    private TextField pantalla;
    private Calculadora calculadora;
    private boolean nuevaEntrada = true;

    public Interfaz(Calculadora calculadora) {
        this.calculadora = calculadora;
    }

    public void iniciarInterfaz(Stage primaryStage) {
        primaryStage.setTitle("Calculadora Básica");

        pantalla = new TextField();
        pantalla.setEditable(false);
        pantalla.setStyle("-fx-font-size: 20px;");
        pantalla.setPrefHeight(50);

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setHgap(10);
        grid.setVgap(10);

        grid.add(pantalla, 0, 0, 4, 1);

        String[] botones = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+"
        };

        int fila = 1;
        int columna = 0;

        for (String texto : botones) {
            Button boton = new Button(texto);
            boton.setPrefSize(60, 60);
            boton.setStyle("-fx-font-size: 18px;");

            boton.setOnAction(e -> manejarEntrada(texto));

            grid.add(boton, columna, fila);

            columna++;
            if (columna > 3) {
                columna = 0;
                fila++;
            }
        }

        // Botón para limpiar la pantalla
        Button botonClear = new Button("C");
        botonClear.setPrefSize(60, 60);
        botonClear.setStyle("-fx-font-size: 18px;");
        botonClear.setOnAction(e -> pantalla.setText(""));
        grid.add(botonClear, 0, fila, 4, 1);

        Scene scene = new Scene(grid, 300, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void manejarEntrada(String entrada) {
        if ("0123456789.".contains(entrada)) {
            if (entrada.equals(".")) {
                if (!pantalla.getText().contains(".")) {
                    pantalla.setText(pantalla.getText() + entrada);
                }
            } else {
                if (nuevaEntrada) {
                    pantalla.setText(entrada);
                    nuevaEntrada = false;
                } else {
                    pantalla.setText(pantalla.getText() + entrada);
                }
            }
        } else if ("+-*/".contains(entrada)) {
            calculadora.establecerPrimerNumero(Double.parseDouble(pantalla.getText()));
            calculadora.establecerOperador(entrada);
            nuevaEntrada = true;
        } else if (entrada.equals("=")) {
            double segundoNumero = Double.parseDouble(pantalla.getText());
            double resultado = calculadora.calcular(segundoNumero);
            pantalla.setText(String.valueOf(resultado));
            nuevaEntrada = true;
        }
    }
}
