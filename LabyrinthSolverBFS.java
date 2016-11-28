/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Labyrinth;
import Labyrinth.interfaces.*;
import java.util.*;
import java.io.*;

/**
 * Solving the labyrinth using BFS algorithm
 * @author Cataln Mazliu
 */
public class LabyrinthSolverBFS
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
    
   
    //BFS queue
    Queue<Cell> BFSQueue = new LinkedList<Cell>();
    

    
    
    /**
     * Constructor
     * @param labyrinth get a labyrinth
     */
   LabyrinthSolverBFS (Labyrinth labyrinth){
        this.labyrinth = labyrinth;
        currentCell = labyrinth.getStartCell();
        
        //adding current cell to exploration list
        //explorationCellList.add(currentCell);
       
        // explorationCellList.add(currentCell);
        BFSQueue.add(currentCell);
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
        
       // explorationCellList.add(currentCell);
        BFSQueue.add(currentCell);
        
        
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
        
        //testing for solution
        Cell finishCell = labyrinth.finishCell();
        if (c.x==finishCell.x && c.y==finishCell.y){
            return false;
        }
        
        //testing for boundaries
        if (c.x<0 || c.x>= labyrinth.getRowCount())
            return false;
        if (c.y<0 || c.y>= labyrinth.getColumnCount())
            return false;
        
        //testing for empty type
        if (!labyrinth.isFreeAt(c.x, c.y))
            return false;
        
        //if the cell has already been explored
        for (Cell xcell : explorationCellList)
        {
            if (xcell.x == c.x && xcell.y == c.y)
            return false;
        }
        //exploring the cell
        //explorationCellList.add(c);
        BFSQueue.add(c);
        currentCell=c;
        
      
        
        return true;
        
    }
    
    /**
     * THe method which solves the maze
     * @return true or false, if can be solved
     */
    public boolean solve(){
        
        System.out.println("Solve started;");
        
        if (BFSQueue.isEmpty()){
            System.out.println("The Queue is empty!");
        }
        //BFS Algorithm
        while (!BFSQueue.isEmpty() && currentCell!=labyrinth.finishCell()){
                System.out.println("Solver running...");
               //getting point of of queue
                currentCell = BFSQueue.remove();
                if (labyrinth.finishCell()==currentCell)
                    break;
                explorationCellList.add((currentCell));
                
                    
                //displaying the cell
                LabyrinthViewStarText lv = new LabyrinthViewStarText(labyrinth);
                lv.setCurrentCell(currentCell);

                System.out.println(lv);
                
                
                
                //activating observers on exploring
                for (LabyrinthObserver obs : observerList){
           
                    obs.processCell(currentCell);
                }
                
                //putting neighbors to queue
                nextCellToExplore(new Cell(currentCell.x-1,currentCell.y));
                
                nextCellToExplore(new Cell(currentCell.x,currentCell.y+1));
                
                nextCellToExplore(new Cell(currentCell.x+1,currentCell.y));
                
                nextCellToExplore(new Cell(currentCell.x,currentCell.y-1));
                
                
        
        }
       
         //activating observers on solution
          for (LabyrinthObserver obs : observerList){
                obs.processSolution(explorationCellList);
            }
        
        
        
        return true;
              
    }

    
}
