package com.challange;

import java.awt.List;
import java.util.ArrayList;
import java.util.Scanner;


class CharacterNode{
	String value;
	CharacterNode leftNode;
	CharacterNode rightNode;

	public CharacterNode(String value) {
		this.value = value;
		this.leftNode = null;
		this.rightNode = null;
	}
}

public class LabelOrderTraversal {
	
	public static void preOrder(CharacterNode root) {
		if(root != null) {
			System.out.print(root.value+" ");
		}
		if(root.leftNode != null) {
			preOrder(root.leftNode);
		}
		if(root.rightNode != null) {
			preOrder(root.rightNode);
		}
		
	}
	
	public static void levellOrderInOneLine(CharacterNode root) {
		Queue queue = new Queue();
		queue.enQueue(root);
		CharacterNode temp = queue.deQueue();
		while(temp != null) {
			System.out.print(temp.value+" ");
			if(temp.leftNode!=null) queue.enQueue(temp.leftNode);
			if(temp.rightNode!=null) queue.enQueue(temp.rightNode);
			temp = queue.deQueue();
		}
	}
	
	public static void levelByLevelOrder(CharacterNode root) {
		Queue queue = new Queue();
		queue.enQueue(root);
		CharacterNode temp = queue.deQueue();
		queue.enQueue(null);
		CharacterNode prevNode = temp;
		while(temp != null || prevNode != null) {
			if(temp != null) {				
				System.out.print(temp.value+" ");
				if(temp.leftNode!=null) queue.enQueue(temp.leftNode);
				if(temp.rightNode!=null) queue.enQueue(temp.rightNode);
			}else {
				queue.enQueue(null);
				System.out.println();
			}
			prevNode = temp;
			temp = queue.deQueue();
		}
	}

	public static class Queue{
		ArrayList<CharacterNode> list;

		public Queue() {
			list = new ArrayList<>();
		}

		public void enQueue(CharacterNode node) {
			list.add(node);
		}

		public CharacterNode deQueue() {
			if(list.size()>0)
			return list.remove(0);
			else return null;
		}
	}



	public static CharacterNode insertLeft(CharacterNode parentNode,String value) {
		if(parentNode != null)
			parentNode.leftNode = new CharacterNode(value);
		return parentNode.leftNode;
	}

	public static CharacterNode insertRight(CharacterNode parentNode,String value) {
		if(parentNode != null)
			parentNode.rightNode = new CharacterNode(value);
		return parentNode.rightNode;
	}

	public static void main(String args[]) {

		CharacterNode root,temp;
		Scanner sc = new Scanner(System.in);
		int nodeCount=0,numberOfNode = sc.nextInt();

		System.out.print("Root=");
		String c = sc.next();
		while(c.equals(" ")) {
			c = sc.next();
		}
		root = new CharacterNode(c);
		Queue queue = new Queue();
		queue.enQueue(root);
		nodeCount++;
		temp = queue.deQueue();
		while(temp != null) {

			System.out.print(" Left Node of "+temp.value+" = ");
			c = sc.next();
			if(!c.equals("-")) {
				queue.enQueue(insertLeft(temp, c));;
				nodeCount++;
			}
			if(nodeCount==numberOfNode) break;
			System.out.print(" Right Node of "+temp.value+" = ");
			c = sc.next();
			if(!c.equals("-")) {
				queue.enQueue(insertRight(temp, c));
				nodeCount++;
			}
			if(nodeCount==numberOfNode) break;
			temp = queue.deQueue();
		}
		
		//preOrder(root);
		//levellOrderInOneLine(root);
		levelByLevelOrder(root);

	}
}
