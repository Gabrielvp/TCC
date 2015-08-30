package entity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Homologação
 */
public class Pessoa {

    private int idPessoa;
    private String nome;
    private String email;
    private boolean completo;
    
    @Override
    public String toString() {
        return idPessoa + nome;
    }    

    public boolean isCompleto() {
        return completo;
    }

    public void setCompleto(boolean completo) {
        this.completo = completo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
