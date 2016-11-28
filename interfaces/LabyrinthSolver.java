/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Labyrinth.interfaces;
import Labyrinth.*;
/**
 * Creates the interface for solving the maze
 * @author Catalin Mazilu
 */
public interface LabyrinthSolver {
    
    /**
     * Returns the current maze
     * @return current maze ready to solve
     */
    public Labyrinth getLabyrinth();
    
    /**
     * sets the desired maze for solving
     */
    public void setLabyrinth(Labyrinth labyrinth);
    
    /**
     * next
     * @param x direction of movement Up, Right, Down. Left
     * @return true or false - if the movement went ok
     */
    public boolean nextCellToExplore(Cell c);
    
    
    /**
     * THe method which solves the maze
     * @return true or false, if can be solved
     */
    public boolean solve();
    
    /**
     * Adds an observer to the Labyrinth
     * @param observer - desired observer
     */
    public void addObserver(LabyrinthObserver observer);
}
