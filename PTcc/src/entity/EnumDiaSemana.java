package entity;

/**
 *
 * @author Homologação
 */
public enum EnumDiaSemana {
    
    DOMINGO(1, "Domingo"),
    SEGUNDA(2, "Segunda-Feira"),
    TERCA(3, "Terça-Feira"),
    QUARTA(4, "Quarta-Feira"),
    QUINTA(5, "Quinta-Feira"),
    SEXTA(6, "Sexta-Feira"),
    SABADO(7, "Sábado");
    
    final String descricao;
    final int codigo;

    public EnumDiaSemana getEnumDiaPorCodigo(int codigo) {
        for (EnumDiaSemana enumDia : EnumDiaSemana.values()) {
            if (enumDia.getCodigo() == codigo) {
                return enumDia;
            }
        }
        return null;
    }
    
    public EnumDiaSemana getEnumDiaPorDia(String dia) {
        for (EnumDiaSemana enumDia : EnumDiaSemana.values()) {
            if (enumDia.getDescricao()== dia) {
                return enumDia;
            }
        }
        return null;
    }
    
    private EnumDiaSemana(int codigo, String descricao) {
        this.descricao = descricao;
        this.codigo = codigo;
    }

    public EnumDiaSemana getEnumPorCodigo(int codigo) {
        for (EnumDiaSemana enumDiaSemana : EnumDiaSemana.values()) {
            if (enumDiaSemana.getCodigo() == codigo) {
                return enumDiaSemana;
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
        return descricao;
    }
}

