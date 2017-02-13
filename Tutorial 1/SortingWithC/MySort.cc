#include <iostream>
#include <fstream>
#include <iterator>
#include <vector>
#include <algorithm>
#include <iostream>
#include <stdio.h>
#include <time.h>
#include <iomanip>

using namespace std;

int main(int argc, char *argv[])
{
	int N;
	sscanf(argv[1], "%d", &N);

	ofstream sortFile;
	sortFile.open("sortFile.txt");
	sortFile << "List Size,Quick\n";

	

	int DataArray[N];
	for(int val = 0; val < N; val++) {
		DataArray[val] = val;
	}
	
	double time;		
	for(int count = 1; count < N; count++) {
		vector<double> data(count);
		for(unsigned int i=0; i<count; i++) {
			data[i] = rand()/(RAND_MAX+1.0);
		}
					
		// Store initial time
		clock_t tStart = clock();
		sort(data.begin(), data.end());
		time = (double)(clock() - tStart)/CLOCKS_PER_SEC;
		//printf("Time taken: %fs\n",time);
		sortFile<< std::fixed << std::setprecision(8)<<("%d,%.4f\n",count,time)<<endl;
	} 
	sortFile.close();				
}

  //printf("Time taken: %fs\n", (double)(clock() - tStart)/CLOCKS_PER_SEC);
  //copy(data.begin(), data.end(), ostream_iterator<double>(cout,"\n"));




