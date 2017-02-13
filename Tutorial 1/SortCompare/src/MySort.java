import java.util.*;

public class MySort
{
	public MySort(int valueCount)
    {
	int N = valueCount;
	double[] data = new double[N];
	for (int i=0; i<N; i++)
	    data[i] = Math.random();
	Arrays.sort(data);
	for (double d: data)
	    System.out.println(d);
    }
}