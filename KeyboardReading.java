/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Labyrinth;
import java.io.*;

/**
 * Demonstrates how to read keys from keyboard
 * @author Catalin Mazilu
 */
public class KeyboardReading {
    
    public static void main(String[] args){
        
        char c;
        c=' ';
        
        while (c!='q'){
            try {
                
                c = (char)System.in.read();
                System.out.println(c);
                
            } catch (IOException e){
                System.out.println("Input Expcepiton");
            }
        }
        
        
    }
}
