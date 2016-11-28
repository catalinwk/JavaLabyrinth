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
public class Lab3 {
    
    public static void main(String[] args){
        
       
        //creating directly a labyrint interface
        /*
            LabyrinthListImpl l1 = new LabyrinthListImpl("c:\\cata\\work\\java\\l1.txt");
        */
        
        // Factory test
            
            Labyrinth l1 = LabyrinthFactory.getLabyrinth("Matrix");
            l1.fileImport("c:\\cata\\work\\java\\l1.txt");
        
        // View test
        /*
            LabyrinthViewStarText view = new LabyrinthViewStarText(l1);
            System.out.println(view);
        
        */
        
        //creating Observers
            SolutionObserver solutionObserver = new SolutionObserver();
            StepObserver stepObserver = new StepObserver();
            
            
        //createing the solver class
        //LabyrinthSolverKeyboard lSolver = new LabyrinthSolverKeyboard(l1);
        LabyrinthSolverBFS lSolver = new LabyrinthSolverBFS(l1);
        
        //adding observers
        lSolver.addObserver((stepObserver));
        lSolver.addObserver(solutionObserver);
      
                
        lSolver.solve();
        
        
        
        
    }
}
