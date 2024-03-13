/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ArquivosJAVA;

/**
 *
 * @author Gahen
 */
public class NewClass {
    
    public static void main(String[] args) {
        
        int i = 0;
        int cont = 0;
        for(i = 1; i <= 50; i++){
            if(i % 6 == 0){
                System.out.println(i);
                cont++;               
        }
        }
        i = 0;
                for(i = 1; i <= 50; i++){
            if(i % 8 == 0){
                System.out.println(i);
                cont++;               
        }
        }
        System.out.println(cont);
    }
}
