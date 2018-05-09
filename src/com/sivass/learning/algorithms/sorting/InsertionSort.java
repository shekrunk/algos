package com.sivass.learning.algorithms.sorting;
import com.sivass.learning.algorithms.utils.ArrayUtils;


public class InsertionSort {
	//TimeComplexity: O(n^2)
	//SpaceComplexity: O(1)
	//Stable Sort
	//In-place Sort
	public static void main(String... args){
		int[] array = new int[]{534, 432, 3, 33, 43, -34, 63, 90, -384};
		
		InsertionSort ins = new InsertionSort();
		//ins.sort(array);
		//ins.sort1(array);
		ins.recursiveSort(array, array.length);
		
		ArrayUtils.print(array);
	}
	
	private void sort(int[] array) {//geeks4geeks
		int len = array.length;
		for(int i=1;i<len;i++) {//start from 2nd element till last element
			int val = array[i];//store value of current element in val
			int j=i-1;
			//compare & move all elements before current element index that are greater than current element after current element index; in ascending order
			while(j>=0 && array[j]>val) {
				array[j+1] = array[j];
				j--;
			}
			array[j+1] = val;
		}
	}
	
	private void sort1(int[] array) {//udemy.com
		for(int firstUnsortedIndex=1;firstUnsortedIndex<array.length;firstUnsortedIndex++) {//start from 2nd element till last element
			int newElement = array[firstUnsortedIndex];//store value of current element in val
			int i;
			for(i=firstUnsortedIndex;i>0&&array[i-1]>newElement;i--){//comparing previous element with newElement and going backwards till index: 1
				array[i] = array[i-1]; //if previous element is greater - moving it to next position;
			}
			array[i] = newElement;
		}
	}
	
	private void recursiveSort(int[] array, int length) {
		if (length == 1) {
			return;
		}
		
		recursiveSort(array, length-1);
		
		int last = array[length-1];
		int j = length-2;
		while(j>=0 && array[j]>last){
			array[j+1] = array[j];
			j--;
		}
		array[j+1] = last;
		
	}
}
