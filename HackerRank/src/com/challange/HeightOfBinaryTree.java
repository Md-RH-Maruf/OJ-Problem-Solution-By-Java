package com.challange;

import java.util.Scanner;


public class HeightOfBinaryTree {
	
	public static int treeHeight(Node root) {
		
		if(root == null) {
			return 0;
		}
		int leftHeight=0, rightHeight = 0;
		if(root.left != null) {
			leftHeight= 1+treeHeight(root.left);
		}
		if(root.right != null) {
			rightHeight= 1+treeHeight(root.right);
		}
		
		return leftHeight>=rightHeight? leftHeight: rightHeight;
		
	}
	
	public static Node insertNode(Node root,int data) {
		
		
		if(root == null) {
			return new Node(data);
		}
		else if(root.data >= data) {
			root.left = insertNode(root.left,data);
		}else {
			root.right = insertNode(root.right,data);;
		}
		return root;
	}
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		Node root=null;
		int t = sc.nextInt();
		while(t-- > 0) {
			int data = sc.nextInt();
			root = insertNode(root, data);
		}
		sc.close();
		System.out.println(treeHeight(root));
		
	}
	
}
