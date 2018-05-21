package com.sivass.learning.datastructures.lists.jdklinkedlists;

import java.util.LinkedList;

import com.sivass.learning.datastructures.lists.linkedlists.Employee;

public class Main {
	
	public static void main(String... args) {
		Employee emp1 = new Employee("name1", "lname1", 123);
		Employee emp2 = new Employee("name2", "lname2", 456);
		Employee emp3 = new Employee("name3", "lname3", 789);
		Employee emp4 = new Employee("name4", "lname4", 101112);
		
		Employee emp5 = new Employee("name5", "lname5", 834);
		
		
		LinkedList<Employee> employeeList = new LinkedList<>();
		employeeList.addFirst(emp3);
		employeeList.addFirst(emp4);
		employeeList.addFirst(emp5);
		
		
		employeeList.add(emp1);//adds to the tail
		employeeList.stream().forEach((e) -> System.out.print(e + ", "));
		
		
	}
	

}
