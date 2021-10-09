package com.volume106;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 class P10611 {
	
	 BufferedReader br;
	 int n,q;
	 int[] ladyHeightList;
	 int luchuHeightList[];
	 
	public int leftIndexSearch(int luchuHeight) {
		int begIndex = 0;
		int lastIndex = n-1;
		int midIndex = 0;
		while(begIndex <= lastIndex) {
			midIndex = (begIndex + lastIndex) / 2;
			
			if(ladyHeightList[midIndex] == luchuHeight) {	
				lastIndex =  midIndex-1;
			}else if(ladyHeightList[midIndex]>luchuHeight) {
				lastIndex = midIndex-1;
			}else if(ladyHeightList[midIndex] < luchuHeight) {
				begIndex = midIndex+1;
			}
		}
		return begIndex;
	}
	
	public int rightIndexSearch(int luchuHeight) {
		int begIndex = 0;
		int lastIndex = n-1;
		int midIndex = 0;
		while(begIndex <= lastIndex) {
			midIndex = (begIndex + lastIndex) / 2;
			
			if(ladyHeightList[midIndex] == luchuHeight) {	
				begIndex =  midIndex+1;
			}else if(ladyHeightList[midIndex]>luchuHeight) {
				lastIndex = midIndex-1;
			}else if(ladyHeightList[midIndex] < luchuHeight) {
				begIndex = midIndex+1;
			}
		}
		return begIndex;
	}
	
	public void began() throws NumberFormatException, IOException,ArrayIndexOutOfBoundsException {
		br=new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		
		ladyHeightList =new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			ladyHeightList[i] = Integer.parseInt(st.nextToken());
		}
	
		q = Integer.parseInt(br.readLine());
		
		
		luchuHeightList = new int[q];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<q;i++) {
			luchuHeightList[i] = Integer.parseInt(st.nextToken());
		}
		
		
		
		for(int i=0;i<q;i++) {			
			String smallest="X", tallest="X";
			int luchuHeght = luchuHeightList[i];
			int leftIndex = leftIndexSearch(luchuHeght);
			int rightIndex = rightIndexSearch(luchuHeght);
			
			//System.out.println("height="+luchuHeght+", left index="+leftIndex+", right index="+rightIndex);
			
			if(leftIndex == n) {
				smallest = String.valueOf(ladyHeightList[leftIndex-1]);
			}else if(ladyHeightList[leftIndex] == luchuHeght) {
				if(leftIndex > 0) smallest = String.valueOf(ladyHeightList[leftIndex-1]);
				if(rightIndex < n-1) tallest = String.valueOf(ladyHeightList[rightIndex]);
			}else {
				if(leftIndex > 0) smallest = String.valueOf(ladyHeightList[leftIndex-1]);
				if(rightIndex < n) tallest = String.valueOf(ladyHeightList[rightIndex]);
			}
			
			
			System.out.println(smallest+" "+tallest);
			
			
		}
	}
	
	public static void main(String args[]) throws NumberFormatException, IOException {
		//Scanner sc = new Scanner(System.in);
		P10611 ob = new P10611();
		ob.began();
	}
	
	
}
