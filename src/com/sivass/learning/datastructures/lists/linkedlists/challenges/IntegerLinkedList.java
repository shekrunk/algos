package com.sivass.learning.datastructures.lists.linkedlists.challenges;

//insert nodes in sorted order
public class IntegerLinkedList {
	private IntegerNode head;
	private int size;
	
	//note: inputs are not in sorted order
	public boolean insertSorted(int value) {
		
		//assumption List is sorted
		if(null == head || head.getData() >= value) {//if head is null or value is less than head
			addToFront(value);
		} else {
			//find insertion point
			IntegerNode newNode = new IntegerNode(value);
			IntegerNode curr = head.getNext();
			IntegerNode prev = head;
			
			while(curr!=null && curr.getData() < value) {
				prev = curr;
				curr = curr.getNext();
			}
			//curr is null or no data < value
			newNode.setNext(curr);
			prev.setNext(newNode);
			size++;
		}
		return true;
	}
	
	
	public boolean addToFront(int value) {
		IntegerNode newNode = new IntegerNode(value);
		newNode.setNext(head);
		head = newNode;
		size++;
		return true;
	}
	

	public int size() {
		return this.size;
	}
	
	public void print() {
		System.out.print("HEAD -> ");
		System.out.println(head);
		System.out.println(size());
	}
}
