package com.trabajiwi.model;

import java.util.Scanner;

public class Juego {

    private Tablero tablero;
    private Estado currentState;
    private TipoFicha currentPlayer;

    private static Scanner in = new Scanner(System.in);  // input Scanner


    public Juego() {
        tablero = new Tablero(3,3);

        initGame();
    }

    public void initGame() {
        tablero.init();  // clear the board contents
        currentPlayer = TipoFicha.CROSS;       // CROSS plays first
        currentState = Estado.PLAYING; // ready to play
    }
}
