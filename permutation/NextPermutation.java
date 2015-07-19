/**
 * 
 * @author liunian
 * 2015-07-19
 * 下一个排列
 * 
 * 思路: 从序列后面开始，查找一个最长递增序列
 * 然后将序列反转，同时将序列之前的第一个数字，和序列中第一个比这个数字大的数字交换
 * 
 * 解释:
 * 
 * 比如序列:
 * 5 3 4 2 1
 * 
 * 从序列后面开始的最长递增序列为: 4 2 1
 * 将序列反转:
 * 5 3 1 2 4 
 * 
 * 同时
 * 将3 和 4 进行交换
 * 得到的序列：
 * 5 4 1 2 3
 *
 */
public class NextPermutation {
	public void nextPermutation(int[] nums) {
		if (nums == null || nums.length <= 0) {
			return;
		}

		int n = nums.length;
		int x = 0;
		for (x = n - 2; (x >= 0) && (nums[x] >= nums[x + 1]); --x)
			;
		if (x < 0) {
			reverse(nums, 0, n - 1);
			return;
		}

		int y = 0;
		for (y = n - 1; (y >= 0) && (nums[y] <= nums[x]); --y)
			;
		swap(nums, x, y);
		reverse(nums, x + 1, n - 1);
	}

	private void reverse(int[] nums, int s, int e) {
		while (s < e) {
			swap(nums, s++, e--);
		}
	}

	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}
