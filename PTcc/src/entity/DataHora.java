package entity;

import java.util.Date;

/**
 *
 * @author Gabriel1
 */
public class DataHora {
    
    private Date data;
    private Date horario;
    private String dia;

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getHorario() {
        return horario;
    }

    public void setHorario(Date horario) {
        this.horario = horario;
    }

}
