/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;

/**
 *
 * @author Gabriel
 */
public class Parcelas_CReceber {
    
    private int idParcelas_CReceber;
    private String fatura;
    private String parcelas;
    private double valor;
    private Date entrada;
    private Date vencimento;
    private int intervalo;
    private int idOrcamento;
    private int idCReceber;

    public int getIdParcelas_CReceber() {
        return idParcelas_CReceber;
    }

    public void setIdParcelas_CReceber(int idParcelas_CReceber) {
        this.idParcelas_CReceber = idParcelas_CReceber;
    }

    public String getFatura() {
        return fatura;
    }

    public void setFatura(String fatura) {
        this.fatura = fatura;
    }

    public String getParcelas() {
        return parcelas;
    }

    public void setParcelas(String parcelas) {
        this.parcelas = parcelas;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getEntrada() {
        return entrada;
    }

    public void setEntrada(Date entrada) {
        this.entrada = entrada;
    }

    public Date getVencimento() {
        return vencimento;
    }

    public void setVencimento(Date vencimento) {
        this.vencimento = vencimento;
    }

    public int getIntervalo() {
        return intervalo;
    }

    public void setIntervalo(int intervalo) {
        this.intervalo = intervalo;
    }

    public int getIdOrcamento() {
        return idOrcamento;
    }

    public void setIdOrcamento(int idOrcamento) {
        this.idOrcamento = idOrcamento;
    }

    public int getIdCReceber() {
        return idCReceber;
    }

    public void setIdCReceber(int idCReceber) {
        this.idCReceber = idCReceber;
    }
    
}
