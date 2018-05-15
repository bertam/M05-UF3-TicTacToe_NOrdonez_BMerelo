package com.trabajiwi.model;

public class Tablero {
    private int filas;
    private int columnas;

    //fila y columna de la ficha actual
    private int filaActual;
    private int columnaActual;
    private Casilla[][] casillas;

    public Tablero(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        casillas = new Casilla[filas][columnas];
        for (int fila = 0; fila < filas; fila++) {
            for (int columna = 0; columna < columnas; columna++) {
                casillas[fila][columna] = new Casilla(new Posicion(fila, columna));
            }
        }
    }
}
