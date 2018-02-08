package cs6301.g45.Q1;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * @author Bhakti Khatri
 * @author Lopamudra Muduli
 * @author Sangeeta Kadambala
 * @author Gautam Gunda
 */


public class Driver {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in;
	        if (args.length > 0) {
	        	String path = args[0];
	            File inputFile = new File(path);
	            in = new Scanner(inputFile);
	        } else {
	            in = new Scanner(System.in);
	        }
		Graph g = Graph.readGraph(in,true); // create directed graph
		
		//Print the all edges
		printEdges(g);
				
		TopologicalOrder tp = new TopologicalOrder(g);
		List<Graph.Vertex> result = tp.toplogicalOrder1(g);
		List<Graph.Vertex> result_DFS = tp.toplogicalOrder2(g);
		
		
		//Function to print output for toplogicalOrder1 algorithm .
		if(result != null)
		{
			System.out.print("toplogicalOrder1 sort : ");
			for(Graph.Vertex x: result) {
			    System.out.print(x + " ");
			}
			System.out.println();
	    }else{
	    	System.out.println("Graph is not a DAG.");
	    }
		
		//Function to print output for toplogicalOrder2 in reverse order of list .
		if(result_DFS != null)
		{
			System.out.print("toplogicalOrder2 sort : ");
			int length = result_DFS.size();
			for(int i = length - 1; i >= 0; i--) {
			    System.out.print((result_DFS.get(i).name+1) + " ");
			}
			System.out.println();
	    }else{
	    	System.out.println("Graph is not a DAG.");
	    }
	}
	
	public static void printEdges(Graph g){
		Iterator<Graph.Vertex> vertexItrator = g.iterator();
		System.out.print("Edges of graph: ");
		while(vertexItrator.hasNext()){
			Iterator<Graph.Edge> edgeIterator = ((Graph.Vertex)vertexItrator.next()).iterator();
			while(edgeIterator.hasNext())
				System.out.print(edgeIterator.next() + " ");
		}
		System.out.println();
	}
}
