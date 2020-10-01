package array;

import java.util.HashSet;

public class CheckIfNExist {

	public static void main(String[] args) {
		int arr[] = { 3, 1, 7, 11 };
		HashSet<Integer> hashSet = new HashSet<Integer>();
		for (int x = 0; x < arr.length; x++) {
			if (hashSet.contains(arr[x] * 2) || (arr[x] % 2 == 0 && hashSet.contains(arr[x] / 2))) {
				System.out.println("true");
			}
			hashSet.add(arr[x]);
		}
		System.out.println("false");
	}

}
