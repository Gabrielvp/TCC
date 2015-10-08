/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Gabriel
 */
public class Orcamento {

    private int idOrcamento;
    private Date data;
    private String nome;
    private double total;
    private double desconto;
    private int idPessoa;
    private List<ProdutoOrcamento> produto;
    private boolean aprovado;

    public List<ProdutoOrcamento> getProduto() {
        return produto;
    }

    public void setProduto(List<ProdutoOrcamento> produto) {
        this.produto = produto;
    }

    private ProdutoOrcamento pOrcamento;

    public ProdutoOrcamento getpOrcamento() {
        return pOrcamento;
    }

    public void setpOrcamento(ProdutoOrcamento pOrcamento) {
        this.pOrcamento = pOrcamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdOrcamento() {
        return idOrcamento;
    }

    public void setIdOrcamento(int idOrcamento) {
        this.idOrcamento = idOrcamento;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public boolean isAprovado() {
        return aprovado;
    }

    public void setAprovado(boolean aprovado) {
        this.aprovado = aprovado;
    }

}
