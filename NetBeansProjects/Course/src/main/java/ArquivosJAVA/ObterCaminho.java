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
public class ObterCaminho {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a directory:"); // ex C:\temp
        String strPath = sc.nextLine();
        
        File path = new File(strPath);
        
        System.out.println("getName: "+ path.getName());
        System.out.println("getParent: "+ path.getParent());
        System.out.println("getPath: "+ path.getPath());
    }
}
