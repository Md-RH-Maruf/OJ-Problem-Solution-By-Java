package com.challange;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

public class DownToZero {

	
	
	
	public static void main(String args[]) throws IOException {
		BufferedReader buffRead = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter buffWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
		
		int q = Integer.parseInt(buffRead.readLine().trim());
		
		IntStream.range(0,q).forEach(qItr ->{
			try {
				int n = Integer.parseInt(buffRead.readLine().trim());
				
				int result = Result2.downToZero(n);
				System.out.println(result);
				//buffWriter.write(String.valueOf(result));
				//buffWriter.newLine();
			}catch(IOException ex) {
				throw new RuntimeException(ex);
			}
		});
		buffRead.close();
        //buffWriter.close();
	}
}


class Result {

    /*
     * Complete the 'downToZero' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER n as parameter.
     */

    public static int downToZero(int n) {
    // Write your code here
    	int[] moveList = new int[n+1];
    	for(int i=0;i<n+1;i++) moveList[i] = 0;
    	
    	Queue<Integer> queue = new LinkedList<Integer>();
    	
    	Integer temp = n;
    	
    	while(temp != null) {
    		if(temp == 0) break;
    		
    		int sqr = (int)Math.sqrt(temp);
    		for(int i=sqr; i>1;i--) {
    			if(temp%i ==0 && moveList[temp/i]==0) {
    				queue.add(temp/i);
    				moveList[temp/i] = moveList[temp]+1;
    			}
    		}
    		
    		if(moveList[temp-1] == 0) {
    			queue.add(temp-1);
    			moveList[temp-1] = moveList[temp] + 1;
    		}
    		temp = queue.poll();
    	}
    	
    	return moveList[0];
    }

}