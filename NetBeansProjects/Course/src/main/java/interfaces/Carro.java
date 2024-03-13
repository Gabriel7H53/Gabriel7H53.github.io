/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 *
 * @author Gahen
 */
public class Carro {
    
    
    protected String modelo;
    protected LocalDateTime instanteInicial;
    protected LocalDateTime instanteFinal;

    public Carro(String modelo, LocalDateTime instanteInicial, LocalDateTime instanteFinal) {
        this.modelo = modelo;
        this.instanteInicial = instanteInicial;
        this.instanteFinal = instanteFinal;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public LocalDateTime getInstanteInicial() {
        return instanteInicial;
    }

    public void setInstanteInicial(LocalDateTime instanteInicial) {
        this.instanteInicial = instanteInicial;
    }

    public LocalDateTime getInstanteFinal() {
        return instanteFinal;
    }

    public void setInstanteFinal(LocalDateTime instanteFinal) {
        this.instanteFinal = instanteFinal;
    }

    public long Convert(){
        Duration diferenca = Duration.between(instanteInicial, instanteFinal);
        long horas = diferenca.toHours() % 24;
        long minutos = diferenca.toMinutes() % 60;
        if(minutos > 0){
        horas++;
        }
        return horas;        
    }
    
}
