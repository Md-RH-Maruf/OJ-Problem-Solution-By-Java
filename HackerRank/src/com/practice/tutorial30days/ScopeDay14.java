package com.practice.tutorial30days;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


class Difference {
  	private int[] elements;
  	public int maximumDifference;
    private int n;
    private int temp;
	// Add your code here

    Difference(int[] a){
        this.elements = a;
       
    }
    
    void computeDifference() {
    	 this.n = this.elements.length;
         this.maximumDifference = 0;
         for(int i=0;i<n;i++){
          for(int j=i+1;j<n;j++){
             temp =  Math.abs(elements[i]-elements[j]);
             if(temp  > this.maximumDifference ){
                 this.maximumDifference = temp;
             }
         }   
         }
    }
}
public class ScopeDay14 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();

        Difference difference = new Difference(a);

        difference.computeDifference();

        System.out.print(difference.maximumDifference);
	}
}
