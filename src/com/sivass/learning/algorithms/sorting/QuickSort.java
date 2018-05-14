package com.sivass.learning.algorithms.sorting;

import com.sivass.learning.algorithms.utils.ArrayUtils;

public class QuickSort {
	//TimeComplexity: O(n log2 n); Worst Case: O(n2); depends on pivot
	//UnStable
	
	public static void main(String... args) {
		QuickSort qs = new QuickSort();
		int[] array = new int[] {434, 764, 1, 0, 34390, 6847243, 326, -343, 6343, -4734};
		//array = new int[] {10, 7, 8, 9, 1, 5};
		//array = new int[] {1, 4, 2, 4, 2, 4, 1, 2, 4, 1, 2, 2, 2, 2, 4, 1, 4, 4, 4};
		long start = System.currentTimeMillis();
		qs.sort(array, 0, array.length);
		//qs.sort2(array, 0, array.length-1);
		long end = System.currentTimeMillis();
        System.out.println("Sorting took: " + (end - start) + " ms");
		ArrayUtils.print(array);
	}
	
	
	//udemy.com
	private void sort(int[] array, int start, int end){
		if(end-start < 2) {
			return;
		}
		
		int pivot = partition(array, start, end); //pivot - correct sorted position(index) of the pivot element
		sort(array, start, pivot);//end element inclusive
		sort(array, pivot+1, end);
	}

	private int partition(int[] array, int start, int end) {
		int pivot = array[start]; //using first element as pivot;
		int i = start;
		int j = end;
		
		while(i<j) {
			while(i<j && array[--j]>=pivot);//empty loop; find element from last greater than the pivot; 
			if(i<j) {
				array[i] = array[j];//element greater than pivot must go after pivot
			}
			while(i<j && array[++i]<=pivot);//empty loop; find element from first less than the pivot;
			if(i<j) {
				array[j] = array[i];//element lesser than pivot must go before pivot
			}
		}
		
		array[j] = pivot;
		return j;
	}
	//udemy.com
	
	
	//geeks4geeks
	private void sort2(int[] array, int start, int end){
		if(end-start < 2) {
			return;
		}
		int pivot = partition2(array, start, end); //pivot - correct sorted position(index) of the pivot element
		sort2(array, start, pivot-1);
		sort2(array, pivot+1, end);
	}
	
	private int partition2(int[] array, int start, int end) {
		int pivot = array[end];//using last element as pivot
		int i = start - 1;//one index lesser than start;

		for(int j = start; j<end; j++) {
			if(array[j] <= pivot) {
				i++;
				ArrayUtils.swap(array, i, j);
			}
		}
		ArrayUtils.swap(array, i+1, end);
		return i+1;
	}
	//geeks4geeks

}
