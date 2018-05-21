package com.sivass.learning.datastructures.lists.linkedlists.challenges;

public class Challenge1 {

	// implement addBefore in double linked list

	public static void main(String... args) {
		Employee emp1 = new Employee("name1", "lname1", 123);
		Employee emp2 = new Employee("name2", "lname2", 456);
		Employee emp3 = new Employee("name3", "lname3", 789);
		Employee emp4 = new Employee("name4", "lname4", 101112);
		
		Employee emp5 = new Employee("name5", "lname5", 834);
		
		EmployeeDoublyLinkedList edll = new EmployeeDoublyLinkedList();

		System.out.println();
		edll.addToFront(emp4);
		edll.addToFront(emp2);
		edll.addToFront(emp1);
		edll.print();

		edll.addBefore(emp3, emp1);
		edll.print();
		edll.addBefore(emp5, emp4);
		edll.print();
	}

}
