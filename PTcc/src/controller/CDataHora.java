/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author Gabriel
 */
public class CDataHora {
    
    public boolean verificaHorario(String hora) {
        int h = Integer.parseInt(hora.substring(0, 2));
        int m = Integer.parseInt(hora.substring(3, 4));
        if (h > 24) {
           // limparTela();
            return false;
        } else if (m > 5) {
           // limparTela();
            return false;
        }
        return true;
    }
    
}
