package cs6301.g45.Q3;

import java.io.File;
import java.util.Scanner;

/**
 * Java Program to run DirectedGraphTestEulerian.java 
 * @author Bhakti Khatri
 * @author Lopamudra Muduli
 * @author Sangeeta Kadambala
 * @author Gautam Gunda
 */

public class Driver {

	public static void main (String[] args) throws java.lang.Exception
    {
        Scanner in;
        if (args.length > 0) {
        	String path = args[0];
            File inputFile = new File(path);
            in = new Scanner(inputFile);
        } else {
            in = new Scanner(System.in);
        }
        
        Graph g = Graph.readGraph(in,true);
        DirectedGraphTestEulerian isEulerian = new DirectedGraphTestEulerian(g);
        
        if (isEulerian.testEulerian(g)) {
            System.out.println("The Directed Graph is Eulerian!");
        } else {
            System.out.println("The Directed Graph is NOT Eulerian! ");
        }
    }

}