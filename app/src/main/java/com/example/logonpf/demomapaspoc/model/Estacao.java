package com.example.logonpf.demomapaspoc.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by logonrm on 28/06/2017.
 */

public class Estacao {

    private String nome;
    private String endereco;
    private String latitude;
    private String longitude;
    @SerializedName("capacidade_passageiro_hora_pico")
    private int capacidadePassageiroHoraPico;
    @SerializedName("area_construida_m_2")
    private double areaConstruidaM2;
    @SerializedName("inauguracao")
    private String dataInauguracao;
    private String urlImagem;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public int getCapacidadePassageiroHoraPico() {
        return capacidadePassageiroHoraPico;
    }

    public void setCapacidadePassageiroHoraPico(int capacidadePassageiroHoraPico) {
        this.capacidadePassageiroHoraPico = capacidadePassageiroHoraPico;
    }

    public double getAreaConstruidaM2() {
        return areaConstruidaM2;
    }

    public void setAreaConstruidaM2(double areaConstruidaM2) {
        this.areaConstruidaM2 = areaConstruidaM2;
    }

    public String getDataInauguracao() {
        return dataInauguracao;
    }

    public void setDataInauguracao(String dataInauguracao) {
        this.dataInauguracao = dataInauguracao;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }


}
