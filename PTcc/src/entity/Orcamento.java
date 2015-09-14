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
public class Orcamento {
    
    private int id;
    private Date data;
    private Date hora;
    private Pessoa pessoa;
    private Produto produto;
    private double QtdProduto;
    private double descontoProduto;
    private double descontoOrcamento;
    private double total;
    private boolean aprovado;

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public double getQtdProduto() {
        return QtdProduto;
    }

    public void setQtdProduto(double QtdProduto) {
        this.QtdProduto = QtdProduto;
    }

    public double getDescontoProduto() {
        return descontoProduto;
    }

    public void setDescontoProduto(double descontoProduto) {
        this.descontoProduto = descontoProduto;
    }

    public double getDescontoOrcamento() {
        return descontoOrcamento;
    }

    public void setDescontoOrcamento(double descontoOrcamento) {
        this.descontoOrcamento = descontoOrcamento;
    }

    public boolean isAprovado() {
        return aprovado;
    }

    public void setAprovado(boolean aprovado) {
        this.aprovado = aprovado;
    }    
}
