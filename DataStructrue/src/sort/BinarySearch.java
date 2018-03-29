package sort;

import java.util.Arrays;

public class BinarySearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {6,5,8,9,3,2,1,4};
		QuickSort.quickSort(arr);
		System.out.println(Arrays.toString(arr));
		System.out.println(binarySearch(arr, 5));
	}

	private static int binarySearch(int[] arr, int num) {
		return binarySearch(arr, num, 0, arr.length-1);
	}

	private static int binarySearch(int[] arr, int num, int begin, int end) {
		//+begin个偏移量
		int mid = (end - begin)/2 + begin;
		System.out.printf("mid:%d\n",arr[mid]);
		if(arr[mid] == num) return mid;
		if(arr[mid] < num) {
			begin = mid + 1;
		}
		if(arr[mid] > num) {
			end = mid - 1;
		}
		return binarySearch(arr, num, begin, end);
	}

}
