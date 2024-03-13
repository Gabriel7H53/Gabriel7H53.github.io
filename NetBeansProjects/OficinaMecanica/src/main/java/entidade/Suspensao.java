/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidade;

/**
 *
 * @author Gahen
 */
public class Suspensao extends Servico{
    
        public enum tipo_suspensao {
        Independente, Semi_dependente, Dependente
    };
        
        private boolean troca_molas;
        private boolean vazamento_fluido;
        
        private tipo_suspensao tipo;

    public Suspensao(int sequencial, String descricao, String custo, Status status, tipo_suspensao tipo,boolean troca_molas, boolean vazamento_fluido ) {
        super(sequencial, descricao, custo, status);
        this.troca_molas = troca_molas;
        this.vazamento_fluido = vazamento_fluido;
        this.tipo = tipo;
    }

    public Suspensao(int sequencial, String custo) {
        super(sequencial, custo);
    }
    
    public boolean isTroca_molas() {
        return troca_molas;
    }

    public void setTroca_molas(boolean troca_molas) {
        this.troca_molas = troca_molas;
    }

    public boolean isVazamento_fluido() {
        return vazamento_fluido;
    }

    public void setVazamento_fluido(boolean vazamento_fluido) {
        this.vazamento_fluido = vazamento_fluido;
    }

    public tipo_suspensao getTipo() {
        return tipo;
    }

    public void setTipo(tipo_suspensao tipo) {
        this.tipo = tipo;
    }
       
        @Override  
    public Servico getVisao(){
        return new Suspensao(getSequencial(), getCusto());
    }
    
        @Override
    public String toString(){
         return "[" + getSequencial() + "]" + " Suspensao - Custo : " + getCusto();
    }   
    
                @Override
    public String toStringFull(){
        String str = super.toStringFull() + " Tipo da Suspensao [" + tipo + "] ";
        return str;
    }
}
