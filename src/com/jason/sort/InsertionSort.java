package com.jason.sort;

/**
 * 插入排序
 * @author wufan
 *
 */
public class InsertionSort {

	/**
	 * 直接插入排序(开始遍历，从左到右逐渐变为有序队列)
	 * @param array
	 */
	public static void insertionSort(int[] array) {
		if(array == null || array.length <= 1) {
			return;
		}
		
		int length = array.length;
		
		int i,j;
//		for(i = 1; i < length; i ++) {
//			if(array[i] < array[i-1]) {
//				int temporary = array[i];
//				for(j = i - 1; j >= 0 && array[j] > temporary; j--) {
//					array[j+1] = array[j];
//				}
//				array[j+1] = temporary;
//			}
//		}
		
		for(i = 1; i < length; i++) {
			for(j = i - 1; j >= 0 && array[j] > array[j+1]; j--) {
				// 异或 异为真，同为假
				array[j] = array[j] ^ array[j+1];
				array[j+1] = array[j+1] ^ array[j];
				array[j] = array[j] ^ array[j+1];
			}
		}
	}
	
	
	public static void main(String args[]) {
		int[] array = {15,3,6,8,1,10,40,32,50,65};
//		int[] array = {15,2,5};
		InsertionSort.insertionSort(array);
		for(int tag : array) {
			System.out.println(tag);
		}
	}
	
	
	
}
