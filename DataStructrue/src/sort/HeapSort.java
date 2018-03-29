package sort;

import java.util.Arrays;
//O(nlogn)，时间换空间
public class HeapSort {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {6,5,8,9,3,2,1,4};
		heapSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static void heapSort(int[] arr) {
		//向上调整成最大堆
		trickleUp(arr);
		for (int i = arr.length - 1; i >= 1; i--) {
			//交换堆顶元素和当前最后一个未被排序元素
			swap(arr, 0, i);
			//向下调整成最大堆
			trickleDown(arr, i);
		}
	}
	//自顶向下调整
	private static void trickleDown(int[] arr, int i) {
		for (int j = 0; j < i; j++) {
			
			int biggestChildIndex = 0;
			
			if(2*j + 1 >= i) break;
			else if(2*j + 2 >= i) biggestChildIndex = 2*j + 1;
			else biggestChildIndex = arr[2*j + 1] > arr[2*j + 2] ? 2*j + 1 : 2*j + 2;
			
			if(arr[j] < arr[biggestChildIndex]) swap(arr, biggestChildIndex, j);
		}
	}
	//自底向上调整
	private static void trickleUp(int[] arr) {
		for (int i = arr.length - 1; i > 0; i--) {
			
			int fatherIndex = i % 2 == 0 ? (i-2)/2 : (i-1)/2;
			//最大堆条件，i=1时，子堆满足最大堆
			if(arr[fatherIndex] < arr[i]) {
				swap(arr, i, fatherIndex);
				//每交换一次，都要重新调整，因为向上调整不能保证交换后仍是最大堆
				trickleUp(arr);
				break;
			}
		}
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
