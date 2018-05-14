package com.sivass.learning.algorithms.sorting;

import com.sivass.learning.algorithms.utils.ArrayUtils;

public class RadixSortStrings {
	public static void main(String[] args) {
		RadixSortStrings rs = new RadixSortStrings();
		String [] array = new String [] {"bcdef", "abceed", "abcde",  "sorte", "decef", "dbaqc", "omadd", "bbbbb", "cdged"};
		int radix = 26;//no of alphabets
		int width = 5; //no of letters in each sortable member 
		rs.sort(array, radix, width);
		
		ArrayUtils.print(array);
	}
	
	private void sort(String[] array, int radix, int width){
		for(int i=width-1;i>=0;i--) {//sort based on each digits position from right to left
			radixSort(array, i, radix);
		}
	}
	
	private void radixSort(String[] array, int position, int radix) { 
		int len = array.length;
		int[] countArray = new int[radix];//counting array
		
		for(String value: array) {
			countArray[getCharIndex(position, value)]++;
		}
		
		//adjust counting array to find at what position the value should be present; this makes the sort stable
		for(int i=1;i<countArray.length;i++) {
			countArray[i]+=countArray[i-1];
		}
		
		String[] tmp = new String[len];
		for(int k = len-1;k>=0;k--) {
			tmp[--countArray[getCharIndex(position, array[k])]] = array[k];
		}
		
		//ArrayUtils.print(tmp);
		for (int i = 0; i<len; ++i)
			 array[i] = tmp[i];
		
	}

	private static int getCharIndex(int position, String value) {//get the position of the character in the counting array  
		return value.charAt(position) - 97;//ASCII code of char 'a';
	}
	
	
}
