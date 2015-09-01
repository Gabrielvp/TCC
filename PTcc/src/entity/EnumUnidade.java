/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Homologação
 */
public enum EnumUnidade {
    
    UNIDADE(1, "un"),
    QUILO(2, "kg"),
    LITRO(3, "L"),
    METRO(4, "m");
        
    final String descricao;
    final int codigo;

    private EnumUnidade(int codigo, String descricao) {
        this.descricao = descricao;
        this.codigo = codigo;
    }

    public EnumUnidade getEnumUnidade(int codigo) {
        for (EnumUnidade enumUnidade : EnumUnidade.values()) {
            if (enumUnidade.getCodigo() == codigo) {
                return enumUnidade;
            }
        }
        return null;
    }

    public String getDescricao() {
        return descricao;

    }

    public int getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return descricao ;
    }
    
    
    
    
}
