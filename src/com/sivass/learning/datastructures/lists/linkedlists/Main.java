package com.sivass.learning.datastructures.lists.linkedlists;

public class Main {
	public static void main(String... args) {
		EmployeeLinkedList ell = new EmployeeLinkedList();
		Employee emp1 = new Employee("name1", "lname1", 123);
		Employee emp2 = new Employee("name2", "lname2", 456);
		Employee emp3 = new Employee("name3", "lname3", 789);
		Employee emp4 = new Employee("name4", "lname4", 101112);
		
		Employee emp5 = new Employee("name5", "lname5", 834);
		
		/*ell.addToFront(emp1);
		ell.addToFront(emp4);
		ell.addToFront(emp3);
		ell.addToFront(emp2);
		ell.print();
		
		ell.removeAtFront();
		ell.print();*/
		
		EmployeeDoublyLinkedList edll = new EmployeeDoublyLinkedList();
		
		System.out.println();
		edll.addToFront(emp4);
		edll.addToFront(emp2);
		edll.addToFront(emp1);
		edll.addToFront(emp3);
		edll.addToEnd(emp5);
		edll.print();
		
		System.out.println(edll.size());
		
		edll.removeAtFront();
		edll.print();
		System.out.println(edll.size());
		
		edll.removeAtEnd();
		edll.print();
		System.out.println(edll.size());
	}
}
