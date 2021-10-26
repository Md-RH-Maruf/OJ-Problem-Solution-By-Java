package com.challange;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class LevelOrderBinaryTreeTraversal {

	
	
	
	public static void levelOrder(Node root) {
		Queue<Node> queue = new LinkedList<Node>();
		
		if(root == null) return;
		queue.add(root);
		Node temp = queue.poll();
		
		while(temp != null) {
			System.out.print(temp.data+" ");
			
			if(temp.left != null)
				queue.add(temp.left);
			if(temp.right != null)
				queue.add(temp.right);
			
			temp = queue.poll();
		}
	}
	
	
	
	public static Node insert(Node root,int value) {
		
		Node newNode;
		if(root == null) {
			return new Node(value);
		}
		else if(root.data >= value) {
			newNode = insert(root.left,value);
			root.left = newNode;
		}else {
			newNode = insert(root.right,value);
			root.right = newNode;
		}
		
		return root;
	}
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		int nodeN = sc.nextInt();
		Node root=null;
		while(nodeN-->0) {
			int value= sc.nextInt();
			root = insert(root,value);
		}
		
		sc.close();
		
		levelOrder(root);
	}
}
