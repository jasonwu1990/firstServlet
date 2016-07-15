package com.jason.sort;

/**
 * 选择排序
 * @author wufan
 *
 */
public class SelectSort {

	/**
	 * 直接选择排序
	 * @param array
	 */
	public static void selectSort(int[] array) {
		if(array == null || array.length <= 1) {
			return;
		}
		int length = array.length;
		int tag = 0;
		while(tag < length) {
			int i = tag;
			while(i < length) {
				if(array[tag] > array[i]) {
					array[tag] = array[tag] ^ array[i];
					array[i] = array[i] ^ array[tag];
					array[tag] = array[tag] ^ array[i];
				}
				i++;
			}
			tag++;
		}
	}
	
	
	public static void main(String[] args) {
		int[] array = {15,3,6,8,1,10,40,32,50,65};
//		int[] array = {15,2,5};
		SelectSort.selectSort(array);
		for(int tag : array) {
			System.out.println(tag);
		}
	}
	
}
