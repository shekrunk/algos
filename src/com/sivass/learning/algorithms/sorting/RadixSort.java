package com.sivass.learning.algorithms.sorting;

import com.sivass.learning.algorithms.utils.ArrayUtils;

public class RadixSort {
	public static void main(String[] args) {
		RadixSort rs = new RadixSort();
		int [] array = new int [] {5342, 8943, 1909, 2853, 9058, 1434, 7436};
		int radix = 10;//decimal numbers
		int width = 4; //no of digits in each sortable member 
		rs.sort(array, radix, width);
		
		ArrayUtils.print(array);
	}
	
	private void sort(int[] array, int radix, int width){
		for(int i=0;i<width;i++) {//sort based on each digits position from right to left i.e. lsd to msd; //1234 -> 4,3,2,1
			radixSort(array, i, radix);
		}
	}
	
	private void radixSort(int[] array, int position, int radix) { 
		int len = array.length;
		int[] countArray = new int[radix];//counting array
		
		for(int value: array) {
			countArray[getDigit(position, value, radix)]++;
		}
		
		//adjust counting array to find at what position the value should be present; this makes the sort stable
		for(int i=1;i<countArray.length;i++) {
			countArray[i]+=countArray[i-1];
		}
		
		int[] tmp = new int[len];
		for(int k = len-1;k>=0;k--) {
			tmp[--countArray[getDigit(position, array[k], radix)]] = array[k];
		}
		
		//ArrayUtils.print(tmp);
		//5342, 8943, 2853, 1434, 7436, 9058, 1909
		//1909, 1434, 7436, 5342, 8943, 2853, 9058
		//9058, 5342, 1434, 7436, 2853, 1909, 8943
		//1434, 1909, 2853, 5342, 7436, 8943, 9058
		for (int i = 0; i<len; ++i)
			 array[i] = tmp[i];
		
	}

	private static int getDigit(int position, int value, int radix) {
		return (value/(int) Math.pow(radix, position)) % radix;//(1234/10*10)%10 = 2; for position 2// (1234/10*10*10*10)%10 = 1; for position 4 
	}
	
	
}
