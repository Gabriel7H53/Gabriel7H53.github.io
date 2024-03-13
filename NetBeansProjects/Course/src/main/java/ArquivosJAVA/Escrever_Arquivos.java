/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ArquivosJAVA;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Gahen
 */
public class Escrever_Arquivos {
    
    public static void main(String[] args) {
           
        String[] lines = new String[]{"Gabriel", "Henrique", "Pereira"};
        String path = "C:\\Users\\Gahen\\Documents\\out.txt";        
       //try(BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))){ se o arquivo out ja existir apenas sera acrescentado o conteudo
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(path))){ // cria o arquivo e se ele ja existir apaga e reecria
        for(String line : lines){
         bw.write(line);
         bw.newLine();
        }  
        }catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
