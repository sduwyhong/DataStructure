package sort;

import java.util.Arrays;
//O(n^2)
public class BubbleSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {6,5,8,9,3,2,1,4};
		bubbleSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static void bubbleSort(int[] arr) {
		if(arr.length < 2 || arr == null) throw new IllegalArgumentException("invalid input");
		//交换相邻的两个元素，大的在后面，每遍历一遍，终点前移一位，直到终点=起点
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - (i + 1); j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}

}
