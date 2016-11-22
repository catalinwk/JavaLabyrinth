/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Labirinth;
import Labirinth.*;

/**
 *
 * @author HP
 */
public class Lab3 {
    
    public static void main(String[] args){
        
        LabyrinthListImpl l1 = new LabyrinthListImpl("c:\\cata\\work\\java\\l1.txt");
        System.out.println(l1);
        
        LabyrinthViewStarText view = new LabyrinthViewStarText(l1);
        
        System.out.println(view);
        
        //createing the solver class
        LabyrinthSolverKeyboard lSolver = new LabyrinthSolverKeyboard(l1);
        //lSolver.getLabyrinth();
        lSolver.solve();
        
        
        
        
    }
}
