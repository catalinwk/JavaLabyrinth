/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Labyrinth;
import Labyrinth.interfaces.*;
/**
 * Creates labyrinth objects
 * @author Catalin Mazilu
 */
public class LabyrinthFactory {
    /**
     * The constructor gets a string and returns a corresponding object
     * @param LabyrinthImplementation - desired type of labyrinth
     */
     public static Labyrinth getLabyrinth(String LabyrinthImplementation){
        if (LabyrinthImplementation.equals("Matrix")) {
            return new LabyrinthMatrixImpl();
        }   
        
        if (LabyrinthImplementation.equals("List")) {
            return new LabyrinthListImpl();
        }   
        
        return null;
    }
}
