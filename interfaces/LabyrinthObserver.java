/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Labyrinth.interfaces;
import Labyrinth.*;
import java.util.*;

/**
 * Observer for Labyrinth solving
 * @author Catalin Mazilu
 */
public interface LabyrinthObserver {
    /**
     * Processes given cell
     * @param cell Labyrinth cell
     */
    public void processCell(Cell cell);
    
    /**
     * Processes the Labyrinth solution
     * @param cellList - array of CellList
     */
    public void processSolution(ArrayList<Cell> cellList);
    
}
