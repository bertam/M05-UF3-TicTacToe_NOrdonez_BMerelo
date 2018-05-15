package com.trabajiwi.model;

public class Casilla {
   private TipoFicha tipoFicha;
   private Posicion posicion;

    public Casilla(TipoFicha tipoFicha, Posicion posicion) {
        this.tipoFicha = tipoFicha;
        this.posicion = posicion;
    }


    public Casilla(Posicion posicion) {
        this.posicion = posicion;
    }

    public void limpiar(){
        this.tipoFicha = TipoFicha.EMPTY;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    public TipoFicha getTipoFicha() {
        return tipoFicha;
    }

    public void setTipoFicha(TipoFicha tipoFicha) {
        this.tipoFicha = tipoFicha;
    }

    public Casilla() {
        this.tipoFicha = TipoFicha.EMPTY;
    }
}