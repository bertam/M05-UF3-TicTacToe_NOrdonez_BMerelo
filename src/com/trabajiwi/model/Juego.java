package com.trabajiwi.model;

import java.util.Scanner;

public class Juego {

    private Tablero tablero;
    private Estado currentState;
    private TipoFicha currentPlayer;

    private static Scanner in = new Scanner(System.in);  // input Scanner


    public Juego() {
        tablero = new Tablero(3,3);
        do {
            moverJugador(currentPlayer);
            tablero.dibujar();
            actualizarJuego(currentPlayer);

            if (currentState == Estado.CROSSWON) {
                System.out.println("'X' GANA!");
            } else if (currentState == Estado.NOUGHTWON) {
                System.out.println("'O' GANA!");
            } else if (currentState == Estado.DRAW) {
                System.out.println("EMPATE!");
            }
            // cambiem jugador
            currentPlayer = (currentPlayer == TipoFicha.CROSS) ? TipoFicha.NOUGHT : TipoFicha.CROSS;
        } while (currentState == Estado.PLAYING);
        initGame();
    }

    private void actualizarJuego(TipoFicha currentPlayer) {
    }

    private void moverJugador(TipoFicha currentPlayer) {
    }

    public void initGame() {
        tablero.init();  // clear the board contents
        currentPlayer = TipoFicha.CROSS;       // CROSS plays first
        currentState = Estado.PLAYING; // ready to play
    }
}
