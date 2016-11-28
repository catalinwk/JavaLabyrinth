/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Labyrinth;
import Labyrinth.*;
/**
 * Used to store cell data (x,y)
 * @author Catalin Maziul
 */
public class Cell {
    int x=0;
    int y=0;
    
    
    /**
     * initialises cell
     * @param x row
     * @param y column
     */
    
    public Cell(int x, int y){
        this.x=x;
        this.y=y;
    }
    
    /**
     * Set Cell coordinates
     * @param x cell row
     * @param y cell column
     */
    
    public void setCell(int cellRow, int cellColumn){
        this.x=cellRow;
        this.y=cellColumn;
    }
    
    /**
     * Gets cell column
     * @return column value
     */
    public int getCellColumn(){
        return this.y;
        
    }
    
    /**
     * Gets cell row
     * @return row value
     */
    public int getCellRow(){
        return this.x;
    }
    public String toString(){
        return x+","+y;
    }
}
