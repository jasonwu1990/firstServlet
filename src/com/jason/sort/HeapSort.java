package com.jason.sort;

/**
 * 二叉堆排序（堆的相应基本操作）
 * @author wufan
 *
 */
public class HeapSort {

	/**
	 * 添加一个值到数组中
	 * @param array
	 * @param ele
	 */
	public static int[] addEle(int[] array, int num) {
		if(array == null) {
			return array;
		}
		int[] endArray = new int[array.length + 1];
		System.arraycopy(array, 0, endArray, 0, array.length);
		endArray[array.length] = num;
		return endArray;
	}
	
	/**
	 * 添加一个值到一个最小堆中，并转换为新的最小堆
	 * tag:(1.array本身就是一个最小堆，
	 * 2.使用下面的sortEle算法时间复杂度较高，相当于冒泡排序，
	 * 3.因为array本身是一个最小堆，插入一个值相当于做一个直接插入排序)
	 * @param array
	 * @param ele
	 */
	public static int[] addEleInHeap(int[] array, int num) {
		int[] endArray = HeapSort.addEle(array, num);
		if(endArray == null || endArray.length <= 1) {
			return endArray;
		}
		int tag = endArray.length - 1;
		int temp = endArray[tag];
		int root = (tag-1)/2;
		while(root >= 0 && tag != 0) {
			if(endArray[root] <= temp) {
				break;
			}
			endArray[tag] = endArray[root];
			tag = root;
			root = (tag-1)/2;
		}
		endArray[tag] = temp;
		return endArray;
	}
	
	/**
	 * 将一个array转换为一个最小堆 
	 * @param array
	 * @param n
	 */
	public static void sortEle(int[] array) {
		if(array == null || array.length <= 1) {
			return;
		}
		int n = 0;
		
		while(n <= array.length - 1) {
			if(n <= 0) {
				n++;
				continue;
			}
			// 得到根节点
			int root = (n-1)/2;
			if(array[root] > array[n]) {
				array[root] = array[root] ^ array[n];
				array[n] = array[n] ^ array[root];
				array[root] = array[root] ^ array[n];
			}
			n++;
		}
	}
	
	
	public static void main(String[] args) {
		int[] array = {3,20,11,8,5,6,8,10,50,30};
		
		int[] destArray = HeapSort.addEle(array, 5);
		
		HeapSort.sortEle(destArray);
		for(int tag : destArray) {
			System.out.println(tag);
		}
	}
	
}

