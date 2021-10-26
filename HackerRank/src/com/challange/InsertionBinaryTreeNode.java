package com.challange;

import java.util.Scanner;

public class InsertionBinaryTreeNode {

	
	public static void preOrder(Node root) {
		if(root==null) return;
		
		System.out.print(root.data+" ");
		preOrder(root.left);
		preOrder(root.right);
	}

	public static Node insert(Node root,int data) {
		
		if(root == null) return new Node(data);
		Node newNode = null;
		if(root.data>=data) {
			newNode = insert(root.left,data);
			root.left = newNode;
		}else {
			newNode = insert(root.right,data);
			root.right = newNode;
		}
		
		return root;
		
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		Node root = null;
		
		while(t-->0) {
			int data = sc.nextInt();
			root = insert(root,data);
		}
		
		sc.close();
		preOrder(root);
	}
}
