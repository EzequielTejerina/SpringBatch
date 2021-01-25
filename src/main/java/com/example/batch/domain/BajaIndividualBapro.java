package com.example.batch.domain;

public class BajaIndividualBapro extends BaproLine {

    private String codNovedad;
    private String numAsiv;
    private String numTarjeta;

    public BajaIndividualBapro() {
    }
    public BajaIndividualBapro(String line){
        this.codNovedad = line.substring(0,2);
        this.numAsiv = line.substring(2,21);
        this.numTarjeta = line.substring(21,36);

    }
    public String getCodNovedad() {
        return codNovedad;
    }

    public void setCodNovedad(String codNovedad) {
        this.codNovedad = codNovedad;
    }

    public String getNumAsiv() {
        return numAsiv;
    }

    public void setNumAsiv(String numAsiv) {
        this.numAsiv = numAsiv;
    }

    public String getNumTarjeta() {
        return numTarjeta;
    }

    public void setNumTarjeta(String numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    @Override
    public String toString() {
        return "BajaIndividualBapro{" +
                "codNovedad='" + codNovedad + '\'' +
                ", numAsiv='" + numAsiv + '\'' +
                ", numTarjeta='" + numTarjeta + '\'' +
                '}';
    }
}
