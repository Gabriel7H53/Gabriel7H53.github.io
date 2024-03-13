/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidade;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import persistência.BD;

/**
 *
 * @author Gahen
 */
public class Motor extends Servico{
    
        public enum componente_reparado {
        Cabecote, Juntas, Valvulas, Pistao, Virabrequim
    };
        
        private componente_reparado componente;
        private boolean restauracao_motor;
        private boolean ajuste_valvulas;
        private String relatorio_tecnico;
        
        
    public Motor(int sequencial, String descricao, String custo, Status status, componente_reparado componente, boolean restauracao_motor, boolean ajuste_valvulas, String relatorio_tecnico) {
        super(sequencial, descricao, custo, status);
        this.restauracao_motor = restauracao_motor;
        this.ajuste_valvulas = ajuste_valvulas;
        this.relatorio_tecnico = relatorio_tecnico;
        this.componente = componente;
    }

    public Motor(int sequencial, String custo) {
        super(sequencial, custo);
    }

    
    
    public componente_reparado getComponente() {
        return componente;
    }

    public void setComponente(componente_reparado componente) {
        this.componente = componente;
    }

    public boolean isRestauracao_motor() {
        return restauracao_motor;
    }

    public void setRestauracao_motor(boolean restauracao_motor) {
        this.restauracao_motor = restauracao_motor;
    }

    public boolean isAjuste_valvulas() {
        return ajuste_valvulas;
    }

    public void setAjuste_valvulas(boolean ajuste_valvulas) {
        this.ajuste_valvulas = ajuste_valvulas;
    }

    public String getRelatorio_tecnico() {
        return relatorio_tecnico;
    }

    public void setRelatorio_tecnico(String relatorio_tecnico) {
        this.relatorio_tecnico = relatorio_tecnico;
    }
    
    @Override
    public Servico getVisao(){
        return new Motor(getSequencial(), getCusto());
    }
    
    
    @Override
    public String toString(){
        
         return "[" + getSequencial() + "]" + " Motor - Custo : " + getCusto() ;
    }
    
        @Override
    public String toStringFull(){
        String str = super.toStringFull() + " Componente Reparado [" + componente + "] ";
        return str;
    }
}
