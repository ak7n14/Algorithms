import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.io.*;

public class TimeGraphSolvetoFile {
	static int MaxListLength = 1000;
	
    public static void main(String args[]) {
		try {
			PrintStream javaList = new PrintStream("javaList.txt");
			PrintStream javaArray = new PrintStream("javaArray.txt");
			
			// File Headers
	    	javaList.printf("List Size,Quick\n");
	    	javaArray.printf("List Size,Quick\n");
	    	
	    	// Populate array of array lengths
			int N[] = new int[MaxListLength];
			for(int val = 0; val < N.length; val++)
				N[val] = val;
			
			// Initialise array to store values for each algorithm
			double[] repeatValues = new double[3];
			
			// Used used to store time at start of sort
			long time_prev;
			// Used to store time taken to sort array
			double time;
			
			// Iterate through array lengths
			for(int count = 1; count < N.length; count++) {
				
				// Create array to store randomly generated values
				double[] data = new double[count];
				
				for(int repeat = 0; repeat <= 2; repeat++){
					
					// Generate random data to be sorted
					for (int i = 0; i < data.length; i++)
					    data[i] = Math.random();
					
					// Store initial time
					time_prev = System.nanoTime();
					MySort(N[count]);
					time = (System.nanoTime()-time_prev)/1000000000.0;
					
					repeatValues[repeat] = time;
				}
				javaList.printf("%d,%f\n",N[count], median(repeatValues));
				System.out.println(count);
			}
			
			// Iterate through array lengths
			for(int count = 1; count < N.length; count++) {
							
				// Create array to store randomly generated values
				double[] data = new double[count];
							
				for(int repeat = 0; repeat <= 2; repeat++){			
					// Generate random data to be sorted
					for (int i = 0; i < data.length; i++)
						data[i] = Math.random();
								
					// Store initial time
					time_prev = System.nanoTime();
					MySortAL(N[count]);
					time = (System.nanoTime()-time_prev)/1000000000.0;
								
					repeatValues[repeat] = time;
				}
				javaArray.printf("%d,%f\n",N[count], median(repeatValues));
				System.out.println(count);
			}
			javaList.close();
			javaArray.close();
		} catch (FileNotFoundException e) {
			System.err.println("Files could not be created.");
			e.printStackTrace();
		}
    }
    
    public static void MySort(int valueCount)
        {
    	int N = valueCount;
    	double[] data = new double[N];
    	for (int i=0; i<N; i++)
    	    data[i] = Math.random();
    	Arrays.sort(data);
    	for (double d: data)
    	    System.out.println(d);
        }
    
    public static void MySortAL(int valueCount)
    {
	int N = valueCount;
	List<Double> data = new ArrayList<Double>(N);
	for (int i=0; i<N; i++)
	    data.add(Math.random());
	Collections.sort(data);
	for (double d: data)
	    System.out.println(d);
    }

    public static double median(double[] a) {
		Arrays.sort(a);
		return a[a.length/2];
    }
}