/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Labyrinth;
import Labyrinth.interfaces.*;
import java.util.*;
import java.io.*;


/**
 * Solving the labyrinth using keyboard strokes
 * @author Catalin Mazilu
 */
public class LabyrinthSolverKeyboard 
implements LabyrinthSolver
{
    /*
     * current cell position
     */
    Cell currentCell = new Cell(0,0);
    
    /*
     * keeping the list of explored cells
     */
    ArrayList<Cell> explorationCellList = new ArrayList<Cell>();
    
   
    
    /**
     * Internal copy of maze - useful for changing current cell after initialisation
     */
    Labyrinth labyrinth;
    
    /**
     * List of observers
     */
    ArrayList<LabyrinthObserver> observerList = new ArrayList<LabyrinthObserver>();
    
    
    
    /**
     * Constructor
     * @param labyrinth get a labyrinth
     */
   LabyrinthSolverKeyboard (Labyrinth labyrinth){
        this.labyrinth = labyrinth;
        currentCell = labyrinth.getStartCell();
        
        //adding current cell to exploration list
        explorationCellList.add(currentCell);
   }
    
    
    
      /**
     * Returns the current maze
     * @return current maze ready to solve
     */
    public Labyrinth getLabyrinth(){
        return labyrinth;
    }
    
    /**
     * sets the desired maze for solving
     */
    public void setLabyrinth(Labyrinth labyrinth){
        this.labyrinth = labyrinth;
        
        currentCell = this.labyrinth.getStartCell();
        
        explorationCellList.add(currentCell);
        
    }
    
       
    /**
     * Adds an observer to the Labyrinth
     * @param observer - desired observer
     */
    public void addObserver(LabyrinthObserver observer){
        observerList.add(observer);
    }
    
    
    /**
     * next
     * @param x direction of movement Up, Right, Down. Left
     * @return true or false - if the movement went ok
     */
    
    public boolean nextCellToExplore(Cell c){
        
        //testing for boundaries
        if (c.x<0 || c.x>= labyrinth.getRowCount())
            return false;
        if (c.y<0 || c.y>= labyrinth.getColumnCount())
            return false;
        
        //testing for empty type
        if (!labyrinth.isFreeAt(c.x, c.y))
            return false;
        
        //exploring the cell
        explorationCellList.add(c);
        currentCell=c;
        
        
          
        //displaying the cell
        LabyrinthViewStarText lv = new LabyrinthViewStarText(labyrinth);
        lv.setCurrentCell(c);
        
        System.out.println(lv);
        
        
        
        //activating observers on exploring
        for (LabyrinthObserver obs : observerList){
           
            obs.processCell(c);
        }
        
        
        //activating observers on solution
        if (labyrinth.getCellAt(c.x,c.y)==Labyrinth.FINISH_CELL){
             for (LabyrinthObserver obs : observerList){
                obs.processSolution(explorationCellList);
            }
        }
       
      
        
        return true;
        
    }
    
    /**
     * THe method which solves the maze
     * @return true or false, if can be solved
     */
    public boolean solve(){
        
        //reading chars from keyboard
          char c;
        c=' ';
        
        while (c!='q'){
            try {
                
                c = (char)System.in.read();
                
                switch (c) {
                case 'u':
                    nextCellToExplore(new Cell(currentCell.x-1,currentCell.y));
                    break;
                case 'r':
                    nextCellToExplore(new Cell(currentCell.x,currentCell.y+1));
                    break;
                case 'd':
                    nextCellToExplore(new Cell(currentCell.x+1,currentCell.y));
                    break;
                case 'l':
                    nextCellToExplore(new Cell(currentCell.x,currentCell.y-1));
                    break;
                }               
                
            } catch (IOException e){
                System.out.println("Input Expcepiton");
            }
        }
        
        return true;
              
    }

    
}
