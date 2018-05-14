package com.sivass.learning;

import java.lang.reflect.Array;

public class ArrayUtils {

	public static <T> void print(T array) {
		print(array, array.getClass().getComponentType());
	}
	
	@SuppressWarnings("unchecked")
	private static <T> void print(T array, Class<? extends Object> class1) {
		StringBuilder sb = new StringBuilder();
		if(class1.isPrimitive()) {
	        int length = Array.getLength(array);
	        for (int i = 0; i < length; i++) {
	        	sb.append(Array.get(array, i));
	        	if(i!=length-1) {
					sb.append(", ");
				}
	        }
		} else {
			T[] array1 = (T[]) array;
			for(int i=0;i<array1.length;i++) {
				sb.append(array1[i]);
				if(i!=array1.length-1) {
					sb.append(", ");
				}
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
