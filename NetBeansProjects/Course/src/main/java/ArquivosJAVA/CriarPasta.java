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
public class CriarPasta {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a directory:"); // ex C:\temp
        String strPath = sc.nextLine();
        
        boolean Sucess = new File(strPath + "\\SubDirectory").mkdir();
        System.out.println("Generated: " + Sucess);
    }
}
