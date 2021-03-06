package com.challange;

import java.util.Scanner;

class Node{	
	int data;
	Node left;
	Node right;
	public Node(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

public class PreorderTraversal {
	
	
	public static void preOrder(Node root) {
		if(root != null) {
			System.out.print(root.data+" ");
		}
		if(root.left != null) {
			preOrder(root.left);
		}
		if(root.right != null) {
			preOrder(root.right);
		}
		
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
		preOrder(root);
		
	}
	
}
