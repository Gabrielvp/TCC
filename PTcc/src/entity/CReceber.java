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
public class CReceber {
    
    private int idCReceber;
    private String fatura;
    private double total;
    private Date data;
    private Date vencimento;
    private int parcelas;
    private int idPessoa;
    private String pessoa;
    private String formPagamento;

    public String getPessoa() {
        return pessoa;
    }

    public void setPessoa(String pessoa) {
        this.pessoa = pessoa;
    }

    public int getIdCReceber() {
        return idCReceber;
    }

    public void setIdCReceber(int idCPagar) {
        this.idCReceber = idCPagar;
    }

    public String getFatura() {
        return fatura;
    }

    public void setFatura(String fatura) {
        this.fatura = fatura;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getVencimento() {
        return vencimento;
    }

    public void setVencimento(Date vencimento) {
        this.vencimento = vencimento;
    }

    public int getParcelas() {
        return parcelas;
    }

    public void setParcelas(int parcelas) {
        this.parcelas = parcelas;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getFormPagamento() {
        return formPagamento;
    }

    public void setFormPagamento(String formPagamento) {
        this.formPagamento = formPagamento;
    }
    
    
}
