package com.sivass.learning.datastructures.lists.linkedlists;

public class EmployeeLinkedList {
	private EmployeeNode head;
	private int size;
	
	public void addToFront(Employee employee) {
		EmployeeNode addToFront = new EmployeeNode(employee);
		addToFront.setNext(head);
		head = addToFront;
		size++;
	}
	
	public int size() {
		return this.size;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public EmployeeNode removeAtFront() {
		if(isEmpty()) {
			return null;
			
		}
		EmployeeNode removedNode = head;
		head = head.getNext();
		size--;
		
		removedNode.setNext(null);//clean up
		return removedNode;
	}
	
	public void print()  {
		System.out.print("HEAD -> ");
		System.out.println(head);
	}
}
