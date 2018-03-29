package sort;

import java.util.Arrays;
//O(n^2)，优于选择排序
public class InsertSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {6,5,8,9,3,2,1,4};
		insertSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static void insertSort(int[] arr) {
		if(arr.length < 2 || arr == null) throw new IllegalArgumentException("invalid input");
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if(arr[i] < arr[j]) {
					int temp = arr[i];
					//将[j,i-1]的元素后移一位，然后在j下标插入arr[i]
					for (int k = i - 1; k >= j; k--) {
						arr[k + 1] = arr[k];
					}
					arr[j] = temp;
				}
			}
		}
	}

}
