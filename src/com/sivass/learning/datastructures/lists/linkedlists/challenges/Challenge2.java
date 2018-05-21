package com.sivass.learning.datastructures.lists.linkedlists.challenges;

public class Challenge2 {
	public static void main(String... args) {
		IntegerLinkedList ill = new IntegerLinkedList();
		
		ill.insertSorted(2);
		ill.insertSorted(4);
		ill.insertSorted(1);
		ill.insertSorted(5);
		
		ill.print();
	}
}
