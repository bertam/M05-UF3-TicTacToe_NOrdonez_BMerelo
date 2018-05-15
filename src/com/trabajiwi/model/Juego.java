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
        if (tablero.haGanado(currentPlayer)) {  // check for win
            currentState = (currentPlayer == TipoFicha.CROSS) ? Estado.CROSSWON : Estado.NOUGHTWON;
        } else if (tablero.esEmpate()) {  // check for draw
            currentState = Estado.DRAW;
        }
    }

    private void moverJugador(TipoFicha currentPlayer) {
        boolean validInput = false;  // for validating input
        do {
            if (currentPlayer == TipoFicha.CROSS) {
                System.out.print("Jugador 'X', introduce tu movimiento (fila[1-3] columna[1-3]): ");
            } else {
                System.out.print("Player 'O', introduce tu movimiento (fila[1-3] columna[1-3]): ");
            }
            int fila = in.nextInt() - 1;
            int columna = in.nextInt() - 1;
            if (fila >= 0 && fila < 3 && columna >= 0 && columna < 3
                    && tablero.getCasillas()[fila][columna].getTipoFicha() == TipoFicha.EMPTY) {
                tablero.getCasillas()[fila][columna].setTipoFicha(currentPlayer);
                tablero.setFilaActual(fila);
                tablero.setColumnaActual(columna);
                validInput = true;
            } else {
                System.out.println("Este movimiento en (" + (fila + 1) + "," + (columna + 1)
                        + ") no es valido. Vuelve a insertar");
            }
        } while (!validInput);
    }

    public void initGame() {
        tablero.init();
        currentPlayer = TipoFicha.CROSS;
        currentState = Estado.PLAYING;
    }
}
