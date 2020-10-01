package array;

import java.util.Arrays;

public class ArrayCyclicRotate {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5 };
		System.out.println("Original Array");
		System.out.println(Arrays.toString(arr));
		System.out.println("Rotated Array");
		rotate(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static void rotate(int[] arr) {
		int temp = arr[arr.length - 1];
		for (int x = arr.length - 1; x >= 1; x--) {
			arr[x] = arr[x - 1];
		}
		arr[0] = temp;
	}
}
