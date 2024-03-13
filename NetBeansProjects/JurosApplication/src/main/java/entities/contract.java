/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author Gahen
 */
public class contract {
   
    private Integer number;
    private LocalDateTime data;
    private Double totalValue;

    ArrayList<installment> installments = new ArrayList<>();
    
    public contract(Integer number, LocalDateTime data, Double totalValue) {
        this.number = number;
        this.data = data;
        this.totalValue = totalValue;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }

    public ArrayList<installment> getInstallments() {
        return installments;
    }

    public void setInstallments(ArrayList<installment> installments) {
        this.installments = installments;
    }
    
    
    
}
