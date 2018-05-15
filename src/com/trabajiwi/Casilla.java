package com.trabajiwi;

public class Casilla {
   private TipoFicha tipoFicha;

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