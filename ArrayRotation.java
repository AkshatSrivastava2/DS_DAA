package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArrayRotation {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter Size");
		int size = Integer.parseInt(br.readLine());
		int arr[] = new int[size];
		for (int x = 0; x < size; x++) {
			System.out.println("Enter the number");
			arr[x] = Integer.parseInt(br.readLine());
		}
		System.out.println("Enter the degree of rotation");
		int rotate = Integer.parseInt(br.readLine());
		rotateArray(arr, rotate);
		rotateArrayLeft(arr, rotate);
		rotateArrayGCD(arr, rotate);
		rotateArrayReversalAlgo(arr, rotate);
	}

	private static void rotateArrayReversalAlgo(int[] arr, int rotate) {
		if (arr.length < rotate) {
			System.out.println("Rotation not possible");
			return;
		}
		reverseArray(arr, 0, rotate - 1);
		reverseArray(arr, rotate, arr.length - 1);
		reverseArray(arr, 0, arr.length - 1);

		System.out.println("Final Array");
		for (int x = 0; x < arr.length; x++) {
			System.out.print(arr[x] + " ");
		}
		System.out.println();
	}

	private static void reverseArray(int[] arr, int start, int end) {
		while(start<end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}

	private static void rotateArrayGCD(int[] arr, int rotate) {
		if (arr.length < rotate) {
			System.out.println("Rotation not possible");
			return;
		}

		int gcd = gcd(rotate, arr.length);
		for (int x = 0; x < gcd; x++) {
			int temp = arr[x];
			int y = x;
			while (true) {
				int z = y + rotate;
				if (z >= arr.length) {
					z -= arr.length;
				}
				if (z == x)
					break;
				arr[y] = arr[z];
				y = z;
			}
			arr[y] = temp;
		}

		System.out.println("Final Array");
		for (int x = 0; x < arr.length; x++) {
			System.out.print(arr[x] + " ");
		}
		System.out.println();
	}

	private static int gcd(int a, int b) {
		if (b == 0) {
			return a;
		}
		return gcd(b, a % b);
	}

	private static void rotateArrayLeft(int[] arr, int rotate) {
		if (arr.length < rotate) {
			System.out.println("Rotation not possible");
			return;
		}

		while (rotate != 0) {
			int firstElement = arr[0];
			rotate--;
			for (int x = 0; x < arr.length - 1; x++) {
				int temp = arr[x];
				arr[x] = arr[x + 1];
				arr[x + 1] = temp;
			}
			arr[arr.length - 1] = firstElement;
		}

		System.out.println("Final Array");
		for (int x = 0; x < arr.length; x++) {
			System.out.print(arr[x] + " ");
		}
		System.out.println();
	}

	private static void rotateArray(int[] arr, int rotate) {

		if (arr.length < rotate) {
			System.out.println("Rotation not possible");
			return;
		}

		int temp[] = arr.clone();
		for (int x = 0; x < (arr.length - rotate); x++) {
			temp[x] = arr[rotate + x];
		}

		for (int x = 0; x < rotate; x++) {
			temp[arr.length - rotate + x] = arr[x];
		}

		System.out.println("Final Array");
		for (int x = 0; x < temp.length; x++) {
			System.out.print(temp[x] + " ");
		}
		System.out.println();
	}
}
