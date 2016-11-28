/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Labyrinth;
import Labyrinth.interfaces.*;

import java.util.*;

/**
 * This observer displays info about exploration step
 * @author Catlain Mazliu
 */
public class StepObserver 
implements LabyrinthObserver
{
    /**
     * Constructor
     */
    StepObserver(){
        System.out.println("stepObserver created!");
    }
    
    /**
     * Processes given cell
     * @param cell Labyrinth cell
     */
    @Override
    public void processCell(Cell cell){
        System.out.println("current cell " + cell);
    }
    
    /**
     * Processes the Labyrinth solution
     * @param cellList - array of CellList
     */
    @Override
    public void processSolution(ArrayList<Cell> cellList){
        System.out.println("Current solution is ");
        for (Cell i : cellList){
            System.out.print(i+" ");
        }
    }
}
