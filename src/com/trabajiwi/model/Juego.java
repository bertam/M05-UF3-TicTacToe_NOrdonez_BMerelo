package com.trabajiwi.model;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Juego implements Runnable {

    private Tablero tablero;
    private Estado estadoActual;
    private TipoFicha jugadorActual;

    private static Scanner in = new Scanner(System.in);


    public Juego() {
    }

    private void actualizarJuego(TipoFicha currentPlayer) {
        if (tablero.haGanado(currentPlayer)) {
            estadoActual = (currentPlayer == TipoFicha.CROSS) ? Estado.CROSSWON : Estado.NOUGHTWON;
        } else if (tablero.esEmpate()) {
            estadoActual = Estado.DRAW;
        }
    }

    private void moverJugador(TipoFicha currentPlayer) {
        boolean validInput = false;
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
        jugadorActual = TipoFicha.CROSS;
        estadoActual = Estado.PLAYING;
    }

    @Override
    public void run() {

        tablero = new Tablero(3, 3);
        initGame();

        do {
            moverJugador(jugadorActual);
            tablero.dibujar();
            actualizarJuego(jugadorActual);

            if (estadoActual == Estado.CROSSWON) {
                System.out.println("'X' GANA!");
            } else if (estadoActual == Estado.NOUGHTWON) {
                System.out.println("'O' GANA!");
            } else if (estadoActual == Estado.DRAW) {
                System.out.println("EMPATE!");
            }
            // cambiem jugador
            jugadorActual = (jugadorActual == TipoFicha.CROSS) ? TipoFicha.NOUGHT : TipoFicha.CROSS;
        } while (estadoActual == Estado.PLAYING);
    }
}
