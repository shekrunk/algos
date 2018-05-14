package com.sivass.learning.algorithms.sorting;

import com.sivass.learning.algorithms.utils.ArrayUtils;

public class CountingSort {
	//cant sort decimal points and strings - as they are not discrete
	//TimeComplexity:
	//SpaceComplexity:
	
	public static void main(String... args) {
		CountingSort cs = new CountingSort();
		int[] array = new int[] {1,3,5,6,7,7,4,2,6,8,9,0};
		//cs.sort(array, 0, 9);
		cs.stableSort(array,0,9);
		ArrayUtils.print(array);
	}
	//Unstable Implementation
	private void sort(int[] array, int min, int max) {
		int len = array.length;
		int[] countArray = new int[(max-min)+1];//input's range is 0 - 9
		
		for(int i=0;i<len;i++) {
			countArray[array[i]-min]++;//translate the range to indices 
		}
		int j = 0;
		for(int i=min;i<=max;i++) {//output array can only contain data between these ranges
			while(countArray[i-min]>0) { //while counting array has data
				array[j++] = i; //write it to output
				countArray[i-min]--;
			}
		}
	}
	
	//Stable Implementation
		private void stableSort(int[] array, int min, int max) {
			int len = array.length;
			int[] countArray = new int[(max-min)+1];//input's range is 0 - 9
			
			for(int i=0;i<len;i++) {
				countArray[array[i]-min]++;//translate the range to indices 
			}
//			ArrayUtils.print(countArray);
			for(int i=1;i<countArray.length;i++) {
				countArray[i]+=countArray[i-1];//adjust counting array to find at what position the value should be present
			}
			ArrayUtils.print(countArray);
			int[] tmp = new int[len];
			for(int k = len-1;k>=0;k--) {
				//System.out.println("k: "+ k +", array[k]: "+ array[k] + ", countArray[array[k]]: "+ countArray[array[k]] + ", countArray[array[k]]-1 : " + (countArray[array[k]]-1));
				tmp[--countArray[array[k]]] = array[k];
				//--countArray[array[k]];
			}
//			ArrayUtils.print(tmp);
			 for (int i = 0; i<len; ++i)
				 array[i] = tmp[i];
			 
		}
}
