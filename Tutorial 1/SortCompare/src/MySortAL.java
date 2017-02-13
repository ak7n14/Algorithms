import java.util.*;

public class MySortAL
{
    public MySortAL(int valueCount)
    {
	int N = valueCount;
	List<Double> data = new ArrayList<Double>(N);
	for (int i=0; i<N; i++)
	    data.add(Math.random());
	Collections.sort(data);
	for (double d: data)
	    System.out.println(d);
    }
}