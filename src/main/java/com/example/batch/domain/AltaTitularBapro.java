package com.example.batch.domain;

public class AltaTitularBapro extends BaproLine{
    private String codNovedad;
    private String numTarjeta;
    private String tipoArancel;

    public AltaTitularBapro() {
    }
    public AltaTitularBapro(String line){
        this.codNovedad = line.substring(0,2);
        this.numTarjeta = line.substring(2,18);
        this.tipoArancel = line.substring(20);
    }
    public String getCodNovedad() {
        return codNovedad;
    }

    public void setCodNovedad(String codNovedad) {
        this.codNovedad = codNovedad;
    }

    public String getNumTarjeta() {
        return numTarjeta;
    }

    public void setNumTarjeta(String numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    public String getTipoArancel() {
        return tipoArancel;
    }

    public void setTipoArancel(String tipoArancel) {
        this.tipoArancel = tipoArancel;
    }

    @Override
    public String toString() {
        return "AltaTitularBapro{" +
                "codNovedad='" + codNovedad + '\'' +
                ", numTarjeta='" + numTarjeta + '\'' +
                ", tipoArancel='" + tipoArancel + '\'' +
                '}';
    }
}
