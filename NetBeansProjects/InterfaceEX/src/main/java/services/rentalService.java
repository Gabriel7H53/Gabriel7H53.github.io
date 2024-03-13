/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import entities.Invoice;
import entities.carRental;
import java.time.Duration;

/**
 *
 * @author Gahen
 */
public class rentalService {
    private Double pricePerHour;
    private Double pricePerDay;

    private taxService TaxService;

    public rentalService(Double pricePerHour, Double pricePerDay, taxService TaxService) {
        this.pricePerHour = pricePerHour;
        this.pricePerDay = pricePerDay;
        this.TaxService = TaxService;
    }

    public Double getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(Double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public Double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(Double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public taxService getTaxService() {
        return TaxService;
    }

    public void setTaxService(taxService TaxService) {
        this.TaxService = TaxService;
    }
  
    
    
    public void processInvoice(carRental carRental){
        double minutes = Duration.between(carRental.getStart(), carRental.getFinish()).toMinutes();
        double hours = minutes / 60;
        
        double basicPayment;
        if(hours <= 12){
            basicPayment = pricePerHour * Math.ceil(hours);
        }else{
            basicPayment = pricePerDay * (hours / 24);
        }
        double taxService = TaxService.tax(basicPayment);
        carRental.setInvoice(new Invoice(basicPayment, taxService));
    }
}
