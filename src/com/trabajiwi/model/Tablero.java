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

    public void init(){
        for (int fila = 0; fila < filas; ++fila) {
            for (int columna = 0; columna < columnas; ++columna) {
                casillas[fila][columna].limpiar();
            }
        }
    }

    public boolean esEmpate(){
        for (int row = 0; row < casillas.length; ++row) {
            for (int col = 0; col < casillas[0].length; ++col) {
                if (casillas[row][col].getTipoFicha() == TipoFicha.EMPTY) {
                    return false;
                }
            }
        }
        return true; // empate
    }

    public boolean haGanado(TipoFicha ficha){
        return (casillas[filaActual][0].getTipoFicha() == ficha
                && casillas[filaActual][1].getTipoFicha() == ficha
                && casillas[filaActual][2].getTipoFicha() == ficha
                || casillas[0][columnaActual].getTipoFicha() == ficha
                && casillas[1][columnaActual].getTipoFicha() == ficha
                && casillas[2][columnaActual].getTipoFicha() == ficha
                || filaActual == columnaActual
                && casillas[0][0].getTipoFicha() == ficha
                && casillas[1][1].getTipoFicha() == ficha
                && casillas[2][2].getTipoFicha() == ficha
                || casillas[0][2].getTipoFicha() == ficha
                && casillas[1][1].getTipoFicha() == ficha
                && casillas[2][0].getTipoFicha() == ficha);
    }

    public void dibujar(){
        for (int fila = 0; fila < filas; ++fila) {
            for (int columna = 0; columna < columnas; ++columna) {
                casillas[fila][columna].dibujar();
                if (columna < columnas - 1) System.out.print("|");
            }
            System.out.println();
            if (fila < filas - 1) {
                System.out.println("-----------");
            }
        }
    }
    
    public int getFilas() {
        return filas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }

    public int getFilaActual() {
        return filaActual;
    }

    public void setFilaActual(int filaActual) {
        this.filaActual = filaActual;
    }

    public int getColumnaActual() {
        return columnaActual;
    }

    public void setColumnaActual(int columnaActual) {
        this.columnaActual = columnaActual;
    }

    public Casilla[][] getCasillas() {
        return casillas;
    }

    public void setCasillas(Casilla[][] casillas) {
        this.casillas = casillas;
    }
}
