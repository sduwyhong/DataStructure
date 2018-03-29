package sort;

import java.util.Arrays;
//O(n^2),优于冒泡排序
public class SelectSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {6,5,8,9,3,2,1,4};
		selectSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static void selectSort(int[] arr) {
		if(arr.length < 2 || arr == null) throw new IllegalArgumentException("invalid input");
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if(arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}

}
