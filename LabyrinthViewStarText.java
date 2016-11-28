/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Labyrinth;
import Labyrinth.interfaces.*;
/**
 *
 * @author HP
 */
public class LabyrinthViewStarText 
implements LabyrinthView
{
     /**
     * maze representation as string
     */
    private String maze = "";
    private Cell currentCell;
    private Labyrinth labyrinth;
    
    /**
     * Constructor initialises maze to display
     * @param labyrinth - maze to display
     */
    LabyrinthViewStarText(Labyrinth labyrinth){
        this.labyrinth=labyrinth;
        setLabyrinth(labyrinth);
    }
    
    
    /**
     * Gets the maze as a text to display
     * @return string representation of maze
     */
    public String getLabyrinth(){
        return maze;
    }
    
    /**
     * Sets the labyrinth for viewing
     * @param labyrinth
     */
    public void setLabyrinth(Labyrinth labyrinth){
        for (int i=0; i<labyrinth.getRowCount(); i++)
        {
            for (int j=0; j<labyrinth.getColumnCount(); j++)
            {
                //for exploration only
                int cellValue = labyrinth.getCellAt(i,j);
                
                if (currentCell != null)
                if (currentCell.x == i && currentCell.y == j)
                    cellValue=Labyrinth.CURRENT_CELL;
               
                
                switch (cellValue){
                    case Labyrinth.START_CELL:
                        maze +="|S";
                        break;
                    case Labyrinth.FINISH_CELL:
                        maze += "|F";
                        break;
                    case Labyrinth.WALL_CELL:
                        maze += "|*";
                        break;
                    case Labyrinth.EMPTY_CELL:
                        maze+="|x";
                        break;
                    case Labyrinth.CURRENT_CELL:
                        maze+="|o";
                        break;
                }
         
             
             }//end first for                
              //new line   
             maze+="|\n";         
        }//end 2nd for
    }
    
    /**
     * toString opertaor is redefined
     * @return string
     */
    public String toString(){
        return maze;
    }
    
     /**
     * Sets the current cell for exploration display
     * @param c Current cell
     */
    public void setCurrentCell(Cell c){
        currentCell=c;
        setLabyrinth(labyrinth);
       
    }
    
}
