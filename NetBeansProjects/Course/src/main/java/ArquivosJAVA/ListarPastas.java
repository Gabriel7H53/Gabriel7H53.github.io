/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ArquivosJAVA;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Gahen
 */
public class ListarPastas {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a directory:"); // Exemplo C:\Users
        String strPath = sc.nextLine();
        
        File path = new File(strPath);
        File[] folders = path.listFiles(File::isDirectory);
        for(File folder : folders){
            System.out.println(folder); 
        }
        sc.close();
    }
}
