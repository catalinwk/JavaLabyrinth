/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Labyrinth.interfaces;
import Labyrinth.*;
/**
 * This interface models the text representation of a labyrinth
 * @author Catlain Mazilu
 */
public interface LabyrinthView {
    /**
     * Gets the maze as a text to display
     * @return string representation of maze
     */
    public String getLabyrinth();
    
    /**
     * Sets the labyrinth for viewing
     * @param labyrinth
     */
    public void setLabyrinth(Labyrinth labyrinth);
    
    /**
     * toString opertaor is redefined
     * @return string
     */
    public String toString();
    
    /**
     * Sets the current cell for exploration display
     * @param c Current cell
     */
    public void setCurrentCell(Cell c);
    
}
