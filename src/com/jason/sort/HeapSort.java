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
	
	
	/**
	 * 删除堆中的元素，只能删除第0个(将第0个的值设置为数组最后一个值)
	 * 
	 * @param array
	 * @return
	 */
	public static int[] delEleInHeap(int[] array) {
		if(array == null || array.length <= 0) {
			return null;
		}
		// 最后一个值置为根节点
		array[0] = array[array.length - 1];
		int[] endArray = new int[array.length - 1];
		System.arraycopy(array, 0, endArray, 0, endArray.length);
		
		// 根节点下标
		int root = 0;
		// 获取根节点的值
		int temp = endArray[root];
		// 获得左孩子节点
		int leftChild = 2*root + 1;
		
		while(leftChild < endArray.length) {
			// 若右孩子存在，且右孩子比左孩子小(取左右孩子中最小的那个)
			if(leftChild + 1 < endArray.length && endArray[leftChild + 1] < endArray[leftChild]) {
				leftChild++;
			}
			// 将左右孩子中最小的值和temp值作比较，若孩子值比temp小，则已经符合了堆的规则
			if(endArray[leftChild] > temp) {
				break;
			}
			
			// 小的值上移
			endArray[root] = endArray[leftChild];
			// 更新根节点
			root = leftChild;
			// 更新新的左孩子
			leftChild = 2*root + 1;
		}
		endArray[root] = temp;
		return endArray;
	}
	
	/**
	 * 堆排序(最小堆获得从小到大排序)
	 * 大致逻辑-->将0和堆的最后一个交换，将前n-1个重新构成一个堆，将0和新堆的最后一个交换，重复操作，得到从大到小的排序
	 */
	public static void heapSort(int[] array) {
		// 先转换为一个最小堆
		HeapSort.sortEle(array);
		
		int lastTag = array.length - 1;
		while(lastTag > 0) {
			array[0] = array[0] ^ array[lastTag];
			array[lastTag] = array[lastTag] ^ array[0];
			array[0] = array[0] ^ array[lastTag];
			
			// 根节点下标
			int root = 0;
			// 获取根节点的值
			int temp = array[root];
			// 获得左孩子节点
			int leftChild = 2*root + 1;
			
			while(leftChild < lastTag) {
				// 若右孩子存在，且右孩子比左孩子小(取左右孩子中最小的那个)
				if(leftChild + 1 < lastTag && array[leftChild + 1] < array[leftChild]) {
					leftChild++;
				}
				// 将左右孩子中最小的值和temp值作比较，若孩子值比temp小，则已经符合了堆的规则
				if(array[leftChild] > temp) {
					break;
				}
				
				// 小的值上移
				array[root] = array[leftChild];
				// 更新根节点
				root = leftChild;
				// 更新新的左孩子
				leftChild = 2*root + 1;
			}
			array[root] = temp;
			lastTag --;
		}
	}
	
	
	public static void main(String[] args) {
		int[] array = {3,20,11,8,5,6,8,10,50,30};
		
		int[] destArray = HeapSort.addEle(array, 5);
		
		HeapSort.sortEle(destArray);
		for(int tag : destArray) {
			System.out.println(tag);
		}
		System.out.println("分割线1~~~~~~~~~~~~~~~~~~~~~~~~~~");
		destArray = HeapSort.delEleInHeap(destArray);
		for(int tag : destArray) {
			System.out.println(tag);
		}
		System.out.println("分割线2~~~~~~~~~~~~~~~~~~~~~~~~~~");
		HeapSort.heapSort(destArray);
		for(int tag : destArray) {
			System.out.println(tag);
		}
	}
	
}

