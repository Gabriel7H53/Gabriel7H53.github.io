/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidade;


/**
 *
 * @author Gahen
 */
public class Pneus extends Servico{

    
       public enum marca_pneus {
        Bridgestone, Michellin, Goodyear, Pirelli, Yokohama
    };
       
      public marca_pneus marca;
      
      public boolean balanceamento;
      public boolean alinhamento;

      private int qtd;

    public Pneus(int sequencial, String descricao, String custo, Status status, marca_pneus marca, int qtd, boolean balanceamento, boolean alinhamento) {
        super(sequencial, descricao, custo, status);
        this.marca = marca;
        this.qtd = qtd;
        this.balanceamento = balanceamento;
        this.alinhamento = alinhamento;
    }

    public Pneus(int sequencial, String custo) {
        super(sequencial, custo);
    }
      
    public marca_pneus getMarca() {
        return marca;
    }

    public void setMarca(marca_pneus marca) {
        this.marca = marca;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public boolean isBalanceamento() {
        return balanceamento;
    }

    public void setBalanceamento(boolean balanceamento) {
        this.balanceamento = balanceamento;
    }

    public boolean isAlinhamento() {
        return alinhamento;
    }

    public void setAlinhamento(boolean alinhamento) {
        this.alinhamento = alinhamento;
    }
        @Override
     public Servico getVisao(){
        return new Pneus(getSequencial(), getCusto());
    }
       
       @Override
    public String toString(){
        
         return "[" + getSequencial() + "]" + " Pneus - Custo : " + getCusto();
    }   
            @Override
    public String toStringFull(){
        String str = super.toStringFull() + "Marca dos pneus [" + marca +"] ";
        return str;
    }
}
