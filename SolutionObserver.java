/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Labyrinth;
import java.util.*;
import Labyrinth.interfaces.*;

/**
 * This class observes Labyrinth solutions
 * @author Catalin Mazilu
 */
public class SolutionObserver 
implements LabyrinthObserver
{
    /**
     * Constructor
     */
    SolutionObserver(){
        System.out.println("solutonObserver created!");
    }
    
    /* stores the found solutions */
    private ArrayList<ArrayList<Cell>> solutionList = new ArrayList<ArrayList<Cell>>();
     
    /**
     * Processes given cell
     * @param cell Labyrinth cell
     */
    @Override
    public void processCell(Cell cell){
        
    }
    
    /**
     * Processes the Labyrinth solution
     * @param cellList - array of CellList
     */
    @Override
    public void processSolution(ArrayList<Cell> cellList){
        //adds the solution to the list
        solutionList.add(cellList);
        
        //sorts the array
        Collections.sort(solutionList, new Comparator<ArrayList>(){
         public int compare(ArrayList a1, ArrayList a2) {
                return a1.size() - a2.size(); // assumes you want biggest to smallest
            }
         });
    
        //display solution as letters
        System.out.println("LIsta de celule: " + cellList);
        String solution ="";
        Cell lastCell = cellList.get(0);
        
        for (int i=1; i<cellList.size(); i++){
            Cell cell = cellList.get(i);
            
            if (lastCell.y ==cell.y && lastCell.x > cell.x)
                solution+="U";
            if (lastCell.y ==cell.y && lastCell.x < cell.x)
                solution+="D";
            if (lastCell.x ==cell.x && lastCell.y > cell.y)
                solution+="L";
            if (lastCell.x == cell.x && lastCell.y < cell.y)
                solution+="R";
            
            lastCell=cell;
        }
        System.out.println("Solution: " + solution);
            
    }//end method
    
}
