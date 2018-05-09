package com.sivass.learning.algorithms.sorting;

import com.sivass.learning.algorithms.utils.ArrayUtils;

public class ShellSort {
	public static void main(String... args) {
		ShellSort ss = new ShellSort();
		int[] array = new int[] {9304, 3829, 4349, -343445, 943, 3, 64,-34};
		ss.sort(array);
		
		ArrayUtils.print(array);
	}
	
	private void sort(int[] array){ //udemy & geeks4geeks
		int len = array.length;
		for (int gap = len/2;gap>0;gap/=2){
			for(int i=gap;i<len;i++) {
				int element = array[i];
				int j = i;
				while(j>=gap&&array[j-gap]>element){
					array[j] = array[j-gap];
					j-=gap;
				}
				array[j] = element;
			}
		}
	}
}
