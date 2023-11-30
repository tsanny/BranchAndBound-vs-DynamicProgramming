import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

import algorithms.DynamicProgramming;
import algorithms.BranchAndBound;

class Tester {
	/* A utility function to print array of size n */
	static void printArray(int arr[]) { 
		int n = arr.length; 
		for (int i = 0; i < n; ++i) 
			System.out.print(arr[i]+" "); 
		System.out.println(); 
	} 

    public static int[] readFile(String filePath, int size)throws Exception {
        int[] array = new int[size];
        Scanner sc = new Scanner(new BufferedReader(new FileReader(new File(filePath))));
        for(int i=0;sc.hasNextLine();i++) 
        {
        array[i]=Integer.parseInt(sc.nextLine());
        }
        return array;
    }

    public static void test(String fileName, int size) throws Exception {
        int multiset[] = readFile(fileName, size);
        int multiset2[] = multiset.clone();
        int n = multiset.length;
        
        double dp_begin = System.nanoTime();
        DynamicProgramming.findPartition(multiset, n);
        double dp_end = System.nanoTime();
        double dp_time = (dp_end-dp_begin) / 1000000;
        System.out.println("dp ("+ fileName +  "): "+ dp_time +" milli seconds");
        
        double bnb_begin = System.nanoTime();
        BranchAndBound.findPartition(multiset2);
        double bnb_end = System.nanoTime();
        double bnb_time = (bnb_end-bnb_begin) / 1000000;
        System.out.println("bnb ("+ fileName +  "): "+ bnb_time +" milli seconds");
    }

	// Driver Code 
	public static void main(String args[]) throws Exception {  
        
        /* to avoid JVM warm-up and caching
        affecting running time results,
        run the tests in isolation */

        // test("small.txt", 10);
        // test("medium.txt", 40);
        test("large.txt", 80);
	} 
} 
