package com.challange;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result2 {

    /*
     * Complete the 'solve' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY arr
     *  2. INTEGER_ARRAY queries
     */

    public static List<Integer> solve(List<Integer> arr, List<Integer> queries) {
    // Write your code here
    	
    	int n = arr.size();
    	int q = queries.size();
    	
    	
    	List<Integer> minArray = new ArrayList<Integer>();
    	for(int i = 0;i< q;i++) {
    		int d = queries.get(i);
    		List<Integer> maxArray = new ArrayList<Integer>();
    		
    		for(int j=0;j<(n-d+1);j++) {
    			maxArray.add(Collections.max(arr.subList(j, j+d)));
    		}
    		minArray.add(Collections.min(maxArray));
    	}
    	return minArray;
    }

}
public class QueriesWithFixedLength {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
		String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$","").split(" ");
		
		int n = Integer.parseInt(firstMultipleInput[0]);
		int q = Integer.parseInt(firstMultipleInput[1]);
		List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt).collect(toList());
		
		List<Integer> queries = IntStream.range(0, q).mapToObj(i->{
			try {
				return bufferedReader.readLine().replaceAll("\\s+$", "");
			}catch(IOException ex) {
				throw new RuntimeException(ex);
			}
		}).map(String::trim).map(Integer::parseInt).collect(toList());
		
		List<Integer> result = Result2.solve(arr,queries); 
		
		System.out.println(result.stream().map(Object::toString).collect(joining("\n"))+"\n");
	}
}
