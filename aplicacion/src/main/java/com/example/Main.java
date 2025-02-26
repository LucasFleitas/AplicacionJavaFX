package com.example;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Calculadora calculadora = new Calculadora();
        Interfaz interfaz = new Interfaz(calculadora);
        interfaz.iniciarInterfaz(primaryStage);
    }
}

