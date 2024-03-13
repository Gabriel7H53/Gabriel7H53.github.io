/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

/**
 *
 * @author Gahen
 */
public class brasilTaxService implements taxService{
    
    public Double tax(Double amount){
        
        if(amount <= 100){
            return amount * 0.2;
        }else{
            return amount * 0.15;
        }
    }
}
