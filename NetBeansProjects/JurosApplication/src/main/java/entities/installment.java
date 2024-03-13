/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.time.LocalDateTime;

/**
 *
 * @author Gahen
 */
public class installment {
    
    private LocalDateTime dueDate;
    private LocalDateTime amount;

    public installment(LocalDateTime dueDate, LocalDateTime amount) {
        this.dueDate = dueDate;
        this.amount = amount;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDateTime getAmount() {
        return amount;
    }

    public void setAmount(LocalDateTime amount) {
        this.amount = amount;
    }
    
    
    
}
