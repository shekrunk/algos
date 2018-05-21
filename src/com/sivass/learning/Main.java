package com.sivass.learning.datastructures.lists.arraylist;

import java.util.ArrayList;
import java.util.List;

import com.sivass.learning.ArrayUtils;

public class Main {
	public static void main(String... args) {
		List<Employee> employeeList = new ArrayList<>();
		employeeList.add(new Employee("Jane", "Jones", 123));
		employeeList.add(new Employee("John", "Doe", 456));
		employeeList.add(new Employee("Mary", "Smith", 125));
		employeeList.add(new Employee("Mike", "Wills", 343));
		
		//employeeList.forEach(e -> System.out.println(e));
		
		
		Object[] employeeArray = employeeList.toArray(new Employee[employeeList.size()]);
		ArrayUtils.print(employeeArray);
		
		System.out.println(employeeList.contains(new Employee("Mary", "Smith", 125)));
		System.out.println(employeeList.indexOf(new Employee("Mary", "Smith", 125)));
	}
}
