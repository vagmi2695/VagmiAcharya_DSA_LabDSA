package com.greatlearning.bst;

import java.util.ArrayList;
import java.util.Scanner;

public class BSTSum {
	ArrayList<Integer> nodelist = new ArrayList();

	public static Node newNode(int z) {

		Node temp = new Node();
		temp.left = null;
		temp.data = z;
		temp.right = null;

		return temp;
	}

	public void insert(Node root, Node nn) {
		if (nn.data < root.data) {
			if (root.left == null)
				root.left = nn;
			else
				insert(root.left, nn);
		} else {
			if (root.right == null)
				root.right = nn;
			else
				insert(root.right, nn);
		}
	}

	public void traverse(Node root) {
		if (root != null) {
			// Inorder
			traverse(root.left);
			nodelist.add(root.data);
			traverse(root.right);
			// Preorder
			// nodelist.add(root.data);
			// traverse(root.left);
			// traverse(root.right);
			// //Postorder
			// traverse(root.left);
			// traverse(root.right);
			// nodelist.add(root.data);

		}

	}

	public static void main(String[] args) {
		BSTSum bst = new BSTSum();
		Node root = null;
		Node nn = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no. of nodes");
		int k = sc.nextInt();

		for (int i = 1; i <= k; i++) {
			System.out.println("Enter Data for the node");
			int n = sc.nextInt();
			nn = newNode(n);
			if (root == null)
				root = nn;
			else {
				bst.insert(root, nn);
			}
		}

		bst.traverse(root);
		System.out.println("Enter sum");
		int sum = sc.nextInt();

		int flag = 0;

		for (int i = 0; i < bst.nodelist.size(); i++) {
			if (bst.nodelist.contains(sum - bst.nodelist.get(i))) {
				int a = bst.nodelist.get(i);
				int b = sum - bst.nodelist.get(i);
				System.out.println("Pair found [" + a + "," + b + "]");
				flag = 1;
				break;
			}
		}
		if (flag == 0) {
			System.out.println("Pair not found");
		}

	}
}
