/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Gahen
 */
public class Rental {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        ArrayList<Carro> carro = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter rental data:");
        System.out.println("Car name:");
        String nome = sc.nextLine();
        System.out.println("Data Inicial: dd/MM/yyyy HH:mm");
        String data = sc.nextLine();
        LocalDateTime dataInicial = LocalDateTime.parse(data, formato);
        System.out.println("Data final: dd/MM/yyyy HH:mm");
        data = sc.nextLine();
        LocalDateTime dataFinal = LocalDateTime.parse(data, formato);
        System.out.println("enter price per hour:");
        double priceHour = sc.nextDouble();
        System.out.println("enter price per day:");
        double priceDay = sc.nextDouble();
        carro.add(new Carro(nome, dataInicial, dataFinal));
        
        for (Carro car : carro) {
            long hours = car.Convert();
            double total = 0.0, imposto = 0.0;
            if(hours <= 12){
                total = hours * priceHour;
            }else{
                long dias = hours / 24;
                long horasRestantes = hours % 24;
                if(horasRestantes > 0){
                    dias++;
                }
                total = dias * priceDay;
            }
            if(total <= 100){
                imposto = total * 0.20;
            }else{
                imposto = total * 0.15;
            }
            System.out.println("Basic Payment: " + total);
            System.out.println("Tax: " + imposto);
            System.out.println("Total: "+ (total+imposto));
        }
        sc.close();
    }
}
