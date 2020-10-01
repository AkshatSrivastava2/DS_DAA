package array;

public class DeleteNumber {

	public static void main(String[] args) {
		int ar[] = { 0, 1, 2, 2, 3, 0, 4, 2 };
		int val = 2;
		System.out.println(removeElement(ar, val));
	}

	public static int removeElement(int[] nums, int val) {
		int i = 0, j = 0;
		while (j < nums.length) {
			if (nums[j] == val) {
				j++;
				continue;
			}
			nums[i] = nums[j];
			i++;
			j++;
		}
		return i;
	}
}
