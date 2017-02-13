import java.util.Arrays;
import java.io.*;

public class TimeGraphSolvetoFile {
	
    public static void main(String args[]) {
		try {
			PrintStream dataFile = new PrintStream("allData.txt");
			PrintStream medianDataFile = new PrintStream("medianData.txt");
			
			// File Headers
	    	dataFile.printf("Node Count,Solve Time\n");
	    	medianDataFile.printf("Node Count,Solve Time\n");
	    	
	    	// Populate array of array lengths
			int N[] = {2,3,4,5};
			
			// Initialise arrays to store values for each algorithm
			double[] repeatValues = new double[3];
			
			// Used used to store time at start of sort
			long time_prev;
			// Used to store time taken to sort array
			double time;
			
			// Iterate through array lengths
			for(int count = 0; count < N.length; count++) {
				
				for(int repeat = 0; repeat <= 2; repeat++){
					
					// Node count printed to file of all data
					dataFile.printf("%d,", N[count]);
					
					// Generate worst case graph (i.e. all nodes connected)
					Graph graph = new Graph(N[count], 1.0);
					
					// Store initial time
					time_prev = System.nanoTime();
					
					// Calculate Colouring
				    @SuppressWarnings("unused")
					Colouring colouring = graph.bestColouring(3);
				    
					time = (System.nanoTime()-time_prev)/1000000000.0;
					dataFile.printf("%f\n", time);
					repeatValues[repeat] = time;
					System.out.println(repeat+1);
				}
				medianDataFile.printf("%d,%f\n", N[count], median(repeatValues));
//				medianData[N[count]] = median(repeatValues);
				System.out.printf("- %d - \n",count+1);
			}
			dataFile.close();
			medianDataFile.close();
		} catch (FileNotFoundException e) {
			System.err.println("File 'allData.txt' could not be created.");
			e.printStackTrace();
		}
    }
    public static double median(double[] a) {
    	Arrays.sort(a);
    	return a[a.length/2];
    }
}