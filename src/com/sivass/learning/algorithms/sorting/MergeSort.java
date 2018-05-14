package com.sivass.learning.algorithms.sorting;

import com.sivass.learning.algorithms.utils.ArrayUtils;

public class MergeSort {
	//TimeComplexity: O(n log2 n)
	//SpaceComplexity: 
	public static void main(String[] args){
		MergeSort ms = new MergeSort();
		
		int[] array = new int[]{439, 82985, -34046, 59409, 10943094, 4099443, 43, -8438};
//		array = new int[]{20, 35, -15, 7, 55, 1, -22};
//		array = new int[]{1, 20, 6, 4, 5};
		int counts = ms.sort(array);
		System.out.println(counts);
	
//		ms.sort2(array);
		ArrayUtils.print(array);
	}
	
	
	//udemy.com
	private int sort(int[] array) {
		int start = 0;
		int end = array.length;//end is the number of elements not last element index
		return mergeSort(array, start, end);
	}
	
	private int mergeSort(int[] array, int start, int end) {
		int invCount = 0;
		if(end-start < 2) { //base case
			return invCount;
		}
		
		int mid = (start+end)/2;
		
		invCount = mergeSort(array, start, mid);
		invCount += mergeSort(array, mid, end);
		invCount += merge(array, start, mid, end);
		return invCount;
	}
	
	private int merge(int[] array, int start, int mid, int end) {
		int invCount = 0;
		if(array[mid-1] <= array[mid]) { //compare last element of left half array with first element of right half array - if its true then original array would be sorted
			return invCount;
		}
		
		int temp[] = new int[end-start]; //temp array to store merge results; note: temp array size changes in each recursion call
		int i=start; // i for left half array
		int j=mid;   //j for right half array
		int tempIndex=0;
		
		while(i<mid && j<end) {//loop until ends of both left and right half arrays
			if(array[i] > array[j]) {
				invCount += mid-i;
			}
			temp[tempIndex++] = (array[i] <= array[j]) ? array[i++] : array[j++]; //copy to temp array from both left and right arrays by comparing each element from both halves; <= makes this algorithm stable
		}
		
		//System.arraycopy(sourceArr, startingPostionInSourceArray, destArray,  startingPostionInDestArray, noOfElementsTobeCopied
		//copy left over items from both halves; i - at this point will be last accessed element index + 1 in left array
		//start+tempIndex => no of indices to jump in destination array
		//mid-i => number of elements that are left over in left half array
		System.arraycopy(array, i, array, start+tempIndex, mid-i);//copy left half
		
		//Copy all items from tempArray 
		System.arraycopy(temp, 0, array, start, tempIndex);//copy right half
		return invCount;
	}
	//udemy.com
	
	//geeks4geeks
	
	private void sort2(int[] array) {
		int start = 0;
		int end = array.length-1;//end is the last element index
		mergeSort2(array, start, end);
	}
	
	private void mergeSort2(int[] array, int start, int end) {
		if(end-start < 2) { //base case
			return;
		}
		
		int mid = (start+end)/2;
		mergeSort2(array, start, mid);
		mergeSort2(array, mid+1, end);
		merge2(array,start, mid, end);
	}
	
	private void merge2(int[] array, int start, int mid, int end) {
		int leftSize = mid - start + 1;
		int rightSize = end - mid;
		
		int[] leftTmpArr = new int[leftSize];
		int[] rightTmpArr = new int[rightSize];
		
		for(int i=0;i<leftSize;i++) {
			leftTmpArr[i] = array[start + i];
		}
		
		for(int i=0;i<rightSize;i++) {
			rightTmpArr[i] = array[mid + 1 + i];
		}
		
		int i=0, j=0, k=start;
		while(i<leftSize && j<rightSize) {
			array[k++] = (leftTmpArr[i]<=rightTmpArr[j])?leftTmpArr[i++]:rightTmpArr[j++];
		}
			
		while(i<leftSize) {
			array[k++] = leftTmpArr[i++];
		}
		
		while(j<rightSize) {
			array[k++] = rightTmpArr[j++];
		}
	}
}
