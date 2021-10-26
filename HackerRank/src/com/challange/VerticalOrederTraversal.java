package com.challange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;



public class VerticalOrederTraversal {

	static class CharacterNode{
		int hd;
		String value;
		CharacterNode leftNode;
		CharacterNode rightNode;

		public CharacterNode(String value,int hd) {
			this.hd = hd;
			this.value = value;
			this.leftNode = null;
			this.rightNode = null;
		}
	}
	public static void vericalOrder(CharacterNode root) {
		HashMap<Integer, ArrayList<CharacterNode>> hash = new HashMap<>();
		
		Queue queue = new Queue();
		queue.enQueue(root);
		CharacterNode temp = queue.deQueue();
		ArrayList<Integer> keyList = new ArrayList<>();
		while(temp != null) {
			if(hash.get(temp.hd) == null) {
				hash.put(temp.hd, new ArrayList<CharacterNode>());
				keyList.add(temp.hd);
			}
				
			
			hash.get(temp.hd).add(temp);
			
			if(temp.leftNode != null) queue.enQueue(temp.leftNode);
			if(temp.rightNode != null) queue.enQueue(temp.rightNode);
			
			temp = queue.deQueue();
		}
		
		Collections.sort(keyList);
		for(int key: keyList) {
			
			ArrayList<CharacterNode> tempList  = hash.get(key);
			for(CharacterNode node : tempList) {
				System.out.print(node.value+" ");
			}
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
			parentNode.leftNode = new CharacterNode(value,parentNode.hd-1);
		return parentNode.leftNode;
	}

	public static CharacterNode insertRight(CharacterNode parentNode,String value) {
		if(parentNode != null)
			parentNode.rightNode = new CharacterNode(value,parentNode.hd+1);
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
		root = new CharacterNode(c,0);
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
		vericalOrder(root);
		
	}
}
