package com.sivass.learning.datastructures.lists.linkedlists.challenges;

public class EmployeeDoubleNode {
	
	private Employee employee;
	private EmployeeDoubleNode next;
	private EmployeeDoubleNode previous;
	
	
	public EmployeeDoubleNode (Employee employee) {
		this.setEmployee(employee);
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public EmployeeDoubleNode getNext() {
		return next;
	}

	public void setNext(EmployeeDoubleNode next) {
		this.next = next;
	}

	public EmployeeDoubleNode getPrevious() {
		return previous;
	}

	public void setPrevious(EmployeeDoubleNode previous) {
		this.previous = previous;
	}

	@Override
	public String toString() {
		return employee.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((employee == null) ? 0 : employee.hashCode());
		result = prime * result + ((next == null) ? 0 : next.hashCode());
		result = prime * result
				+ ((previous == null) ? 0 : previous.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeDoubleNode other = (EmployeeDoubleNode) obj;
		if (employee == null) {
			if (other.employee != null)
				return false;
		} else if (!employee.equals(other.employee))
			return false;
		if (next == null) {
			if (other.next != null)
				return false;
		} else if (!next.equals(other.next))
			return false;
		if (previous == null) {
			if (other.previous != null)
				return false;
		} else if (!previous.equals(other.previous))
			return false;
		return true;
	}
	

}
