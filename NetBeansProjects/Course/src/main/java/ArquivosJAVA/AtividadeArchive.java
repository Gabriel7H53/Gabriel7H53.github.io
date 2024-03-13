/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ArquivosJAVA;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Gahen
 */
public class AtividadeArchive {

    public static void main(String[] args) {

        String path = "C:\\temp\\src.csv";
        File file = new File(path);
        
        ArrayList<Produto> produto = new ArrayList<>();
        String vect = null;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            while (line != null) {
                vect = null;
                vect = line;
                String arrayVect[] = vect.split(",");
                String nome = arrayVect[0];
                Double price = Double.parseDouble(arrayVect[1]);
                Integer quantidade = Integer.parseInt(arrayVect[2]);
                produto.add(new Produto(nome, price, quantidade));
                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        new File(file.getParent() + "\\out").mkdir();
        String strPath = "C:\\temp\\out\\summary.csv";
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(strPath))){
            for(Produto product: produto){
                writer.write(product.getName() + ", "+ product.valorTotal());
                writer.newLine();
            }
        }catch(IOException e){
            System.out.println("Error: "+ e.getMessage());
        }
    }
}
