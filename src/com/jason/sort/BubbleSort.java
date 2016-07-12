package com.jason.sort;

/**
 * 
 * @author wufan
 *
 */
public class BubbleSort {

	/**
	 * 冒泡排序
	 * @param array
	 */
	public static void bubbleSort(int[] array) {
		if(array == null || array.length <= 1) {
			return;
		}
		int length = array.length;
		for(int i = 0; i < length; i++) {
			for(int j = 1; j < length - i; j++) {
				if(array[j - 1] > array[j]) {
					array[j - 1] = array[j - 1] ^ array[j];
					array[j] = array[j] ^ array[j - 1];
					array[j - 1] = array[j - 1] ^ array[j];
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[] array = {15,3,6,8,1,10,40,32,50,65};
//		int[] array = {15,2,5};
		BubbleSort.bubbleSort(array);
		for(int tag : array) {
			System.out.println(tag);
		}
		
	}
	
}
