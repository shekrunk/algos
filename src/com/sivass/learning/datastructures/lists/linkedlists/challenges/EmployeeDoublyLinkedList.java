package com.sivass.learning.datastructures.lists.linkedlists.challenges;

public class EmployeeDoublyLinkedList {
	private EmployeeDoubleNode head;
	private EmployeeDoubleNode tail;
	private int size;
	
	public void addToFront(Employee employee) {
		EmployeeDoubleNode addToFront = new EmployeeDoubleNode(employee);
		addToFront.setNext(head);
		addToFront.setPrevious(null);//just for clarity
		
		if(head == null) { //if list is empty - both tail and head will be same new node
			tail = addToFront;
		} else {
			head.setPrevious(addToFront); // if list is non - empty current heads' previous will be pointing to the new node 
		}
		           
		head = addToFront;
		size++;
	}
	
	public void addToEnd(Employee employee) {
		EmployeeDoubleNode addToEnd = new EmployeeDoubleNode(employee);
		
		if(tail == null) {
			head = addToEnd;
		} else {
			tail.setNext(addToEnd);//current tails next will be new node (previously it would be null)
			addToEnd.setPrevious(tail);//set previous of new node to current tail
		}
		
		addToEnd.setNext(null);//set next of new node to last  - as this will be the last node now; just for clarity
		
		tail = addToEnd;//reassign the new node as tail node
		size++;
	}
	
	public int size() {
		return this.size;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public EmployeeDoubleNode removeAtFront() {
		if(isEmpty()) {
			return null;
		}
		
		EmployeeDoubleNode removedNode = head;
		
		if(head.getNext() == null) { // check if only one element in list
			tail = null;
		} else {
			head.getNext().setPrevious(null);
		}
		head = head.getNext();
		size--;
		//clean up
		removedNode.setPrevious(null);//this should already be null; but added for more clarity
		removedNode.setNext(null);
		return removedNode;
	}
	
	public EmployeeDoubleNode removeAtEnd() {
		if(isEmpty()) {
			return null;
		}
		EmployeeDoubleNode removedNode = tail;
		if(tail.getPrevious() == head) {// check if only one element in list
			head = null;
		} else {
			 tail.getPrevious().setNext(null);
		}
		
		tail = tail.getPrevious();
		size--;
		
		//clean up
		removedNode.setPrevious(null);
		removedNode.setNext(null);//this should already be null; but added for more clarity
		return removedNode;
	}
	
	public boolean addBefore(Employee newEmployee, Employee beforeEmployee) {
		EmployeeDoubleNode newEmployeeNode = new EmployeeDoubleNode(newEmployee);
		if(isEmpty() || beforeEmployee == null) {
			return false;
		} 
		
		EmployeeDoubleNode beforeEmployeeNode = getEmployeeNode(beforeEmployee);
		if (beforeEmployeeNode == null) {
			 return false;
		}
		
		newEmployeeNode.setPrevious(beforeEmployeeNode.getPrevious());
		
		newEmployeeNode.setNext(beforeEmployeeNode);
		beforeEmployeeNode.setPrevious(newEmployeeNode);

		if (head == beforeEmployeeNode) {
			head = newEmployeeNode;
		} else {
			newEmployeeNode.getPrevious().setNext(newEmployeeNode);
		}
		size++;
		
		return true;
	}
	
	private EmployeeDoubleNode getEmployeeNode(Employee employee) {
		EmployeeDoubleNode node = head;//start at head
		while(node!=null && !node.getEmployee().equals(employee)) {
			node = node.getNext();			
		}
		return node;
	}
	
	public void print()  {
		System.out.print("HEAD -> ");
		EmployeeDoubleNode node = head;
		while(node != null) {
			System.out.print(node);
			node = node.getNext();
			System.out.print(" <=> ");
		}
		System.out.println(" <- TAIL");
		System.out.println(size());
	}
}
