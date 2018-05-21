package com.sivass.learning.datastructures.lists.linkedlists.challenges;

public class IntegerNode {
	private Integer data;
	private IntegerNode next;
	
	public IntegerNode(Integer data) {
		this.data = data;
		this.next = null;
	}
	
	public Integer getData() {
		return data;
	}
	public void setData(Integer data) {
		this.data = data;
	}
	public IntegerNode getNext() {
		return next;
	}
	public void setNext(IntegerNode next) {
		this.next = next;
	}
	
	@Override
	public String toString() {
		return data + " -> " + next;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((next == null) ? 0 : next.hashCode());
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
		IntegerNode other = (IntegerNode) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (next == null) {
			if (other.next != null)
				return false;
		} else if (!next.equals(other.next))
			return false;
		return true;
	}
	
}
