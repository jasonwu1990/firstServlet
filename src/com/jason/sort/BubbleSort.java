package com.jason.sort;

/**
 * 交换排序
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
			// 判断这一次有没有交换，若没有交换，后面直接break
			boolean change = false;
			for(int j = 1; j < length - i; j++) {
				if(array[j - 1] > array[j]) {
					change = true;
					array[j - 1] = array[j - 1] ^ array[j];
					array[j] = array[j] ^ array[j - 1];
					array[j - 1] = array[j - 1] ^ array[j];
				}
			}
			if(!change) {
				break;
			}
		}
	}
	
	/**
	 * 快速排序
	 * @param array
	 */
	public static void quickSort(int[] array) {
		if(array == null || array.length <= 1) {
			return;
		}
		_quickSort(array, 0, array.length - 1);
	}
	
	// 递归调用
	public static void _quickSort(int[] array, int low, int high) {
		if(low < high) {
			int middle = getMiddle(array, low, high);
			_quickSort(array, low, middle - 1);
			_quickSort(array, middle + 1, high);
		}
	}
	
	// 获取基准点
	public static int getMiddle(int[] array, int low, int high) {
		int flag = array[low];
		while(high > low) {
			while(high > low && array[high] >= flag) {
				high --;
			}
			array[low] = array[high];
			while(high > low && array[low] <= flag) {
				low++;
			}
			array[high] = array[low];
		}
		array[low] = flag;
		return low;
	}
	
	public static void main(String[] args) {
		int[] array = {15,3,6,8,1,10,40,32,50,65};
//		int[] array = {15,2,5};
		BubbleSort.quickSort(array);
		for(int tag : array) {
			System.out.println(tag);
		}
		
	}
	
}
