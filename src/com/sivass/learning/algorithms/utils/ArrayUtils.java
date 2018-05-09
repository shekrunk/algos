package com.sivass.learning.algorithms.utils;

public class ArrayUtils {
	public static void print(int[] array) {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<array.length;i++) {
			sb.append(array[i]);
			if(i!=array.length-1) {
				sb.append(", ");
			}
		}
		System.out.println(sb);
	}
	
	public static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
