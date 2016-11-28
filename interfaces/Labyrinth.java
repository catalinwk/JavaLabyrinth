/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Labyrinth.interfaces;
import Labyrinth.*;
/**
 *
 * @author HP
 */
public interface Labyrinth {
    final int START_CELL = -1;
    final int WALL_CELL = 1;
    final int FINISH_CELL = 2;
    final int EMPTY_CELL = 0;
    final int CURRENT_CELL = 3;
    
    /**
     * Gets number of rows
     * @return number of rows
     */
    public int getRowCount();
    
   

   
  
    
    /**
     * Gets the number of columns
     * @return number of columns
     */
    public int getColumnCount();
    
    /**
     * Checks if a labyrinth cell is free or not
     * @return true or false
     */
    public boolean isFreeAt(int x, int y);
    
    /**
     * Checks if  the cell is a wall or not
     * @return true or false 
     */
    public boolean isWallAt(int x, int y);
    
    /**
     *  Gets cell content
     * @param x row
     * @param y column
     * @return cell content
     */
    public int getCellAt(int x, int y);
    
    
    /**
     * Returns start cell
     * @return start cell
     */
    public Cell getStartCell();
    
    
     
    
    /**
     * Returns finish cell
     * @return finish cell
     */
    public Cell finishCell();
    
    /**
     * Imports Labyrinth data form file
     * @param fileName - name of the file
     * @return true or false based on import result
     */
    
    /**
     * Gets a string representation of Labyrinth for testing
     * @return labyrinth as a string
     */
    public String toString();
      
    /**
     * Imports Labyrinth data form file
     * @param fileName - name of the file
     * @return true or false based on import result
     */
    public boolean fileImport(String fileName);
}
