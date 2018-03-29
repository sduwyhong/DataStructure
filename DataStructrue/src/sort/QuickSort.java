package sort;

import java.util.Arrays;
//O(nlogn)，空间换时间
public class QuickSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {6,5,8,9,3,2,1,4};
		quickSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void quickSort(int[] arr) {
		quickSort(arr, 0, arr.length-1);
	}

	private static void quickSort(int[] arr, int i, int j) {
		if(arr.length < 2 || arr == null) throw new IllegalArgumentException("invalid input");
		//子数组只有1个元素(i==j)或空(i>j)时return
		if(i < j){
			//选择arr[i]作为基准元素
			int left = i;
			int right = j;
			//当左右指针不等
			while(left != right){
				//判断右指针指向元素是否小于基准
				if(arr[right] < arr[left]) {
					//是则交换arr[left] arr[right]
					swap(arr, left, right);
					while(left != right) {
						//判断左指针是否大于基准
						if(arr[left] > arr[right]){
							//若是交换arr[left] arr[right]
							swap(arr, left, right);
							//左指针交换完则结束当前循环
							break;
						}else {
							//否则左指针右移
							left++;
						}
					}
				}else {
					//否则右指针左移
					right--;
				}
			}
			//左右指针相等，将重合处左右子数组进行快速排序
			quickSort(arr, i, left-1);
			quickSort(arr, left+1, j);
		}
	}

	private static void swap(int[] arr, int left, int right) {
//		System.out.printf("swap %d and %d\n", arr[left], arr[right]);
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;		
	}

}
