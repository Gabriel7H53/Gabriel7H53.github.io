/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ArquivosJAVA;

/**
 *
 * @author Gahen
 */
public class Produto {

    private String name;
    private Double price;
    private Integer quantidade;

    public Produto(String name, Double price, Integer quantidade) {
        this.name = name;
        this.price = price;
        this.quantidade = quantidade;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getQuantidade() {
        return quantidade;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double valorTotal() {
    return price * quantidade;
    }
    
    @Override

    public String toString() {
        return name + price + quantidade;
    }

}
