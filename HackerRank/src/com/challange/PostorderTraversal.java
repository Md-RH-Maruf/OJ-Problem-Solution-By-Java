package com.challange;

import java.util.Scanner;

public class PostorderTraversal {
	
	public static void postOrder(Node root) {
		
		if(root != null) {

			if(root.left != null) {
				postOrder(root.left);
			}
			if(root.right != null) {
				postOrder(root.right);
			}
			System.out.print(root.data+" ");
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
		postOrder(root);
		
	}
	
}
