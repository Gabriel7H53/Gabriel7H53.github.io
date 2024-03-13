/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application;

import entities.Vehicle;
import entities.carRental;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;
import services.brasilTaxService;
import services.rentalService;

/**
 *
 * @author Gahen
 */
public class Program {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter ftc = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        System.out.println("Modelo:");
        String modelo = sc.nextLine();
        System.out.println("Retirada: dd/MM/yyyy HH:mm");
        LocalDateTime retirada = LocalDateTime.parse(sc.nextLine(), ftc);
        System.out.println("Retorno: dd/MM/yyyy HH:mm");
        LocalDateTime retorno = LocalDateTime.parse(sc.nextLine(), ftc);

        carRental cr = new carRental(retirada, retorno, new Vehicle(modelo));

        System.out.println("Price per Hour:");
        double pricePerHour = sc.nextDouble();
        System.out.println("Price per Day:");
        double pricePerDay = sc.nextDouble();

        rentalService rs = new rentalService(pricePerHour, pricePerDay, new brasilTaxService());

        rs.processInvoice(cr);

        System.out.println("FATURA:");
        System.out.println("Pagamento basico: " + String.format("%.2f", cr.getInvoice().getBasicPayment()));
        System.out.println("Imposto: " + String.format("%.2f", cr.getInvoice().getTax()));
        System.out.println("Pagamento total: " + String.format("%.2f", cr.getInvoice().totalPayment()));
        sc.close();
    }
}
