package com.challange;

import java.util.*;

public class TopViewTravasel {
	
	
	
	static class ViewNode{
		int value;
		int level;
		public ViewNode(int value,int level) {
			this.value = value;
			this.level = level;
		}
	}

	static TreeMap<Integer, ViewNode> map = new TreeMap<>();
	
	static void fillMap(Node root,int hd,int level) {
		
		if(root == null) {
			return;
		}
		
		if(map.get(hd) == null) {
			map.put(hd, new ViewNode(root.data, level));
		}else if(map.get(hd).level > level) {
			map.put(hd, new ViewNode(root.data, level));
		}
		
		fillMap(root.left, hd-1, level+1);
		fillMap(root.right, hd+1, level+1);
	}
	
	public static void topView(Node root) {
		
		fillMap(root,0,0);
		
		for(Map.Entry<Integer, ViewNode> entity: map.entrySet()) {
			System.out.print(entity.getValue().value+" ");
		}
		
		
	}
	
	public static Node insert (Node root, int data) {
		if(root == null) {
			return new Node(data);
		}
		else {
			Node temp;
			if(data>root.data) {
				temp = insert(root.right,data);
				root.right = temp;
			}else {
				temp = insert(root.left,data);
				root.left = temp;
			}
			return root;
		}
	}
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		Node root = null;
		while(t-- > 0){
			int data = scan.nextInt();
			root = insert(root,data);
		}
		
		scan.close();
		topView(root);
	}
}
