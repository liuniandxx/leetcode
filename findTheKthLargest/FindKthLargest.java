/**
 * 
 * @author liunian
 * 2015/07/06
 *  寻找数组第K大的数
 *  
 *  思想:
 *  快排的 partition 将数组分成两个有相对大小的部分
 *  看中间的轴元素是否为第K大的数
 *  如果比K大，在前半部分找
 *  反之，在后半部分找
 *
 */
public class FindKthLargest {
	public int findKthLargest(int[] nums, int k) {
		return helpFindKthLargest(nums, 0, nums.length - 1, nums.length - k + 1);
	}

	private int helpFindKthLargest(int[] nums, int s, int end, int k) {
		if (s == end) {
			return nums[s];
		}

		int partitionIndex = partition(nums, s, end);
		if (k == partitionIndex - s + 1) {
			return nums[partitionIndex];
		} else if (k < partitionIndex - s + 1) {
			return helpFindKthLargest(nums, s, partitionIndex - 1, k);
		} else {
			return helpFindKthLargest(nums, partitionIndex + 1, end, k
					- (partitionIndex - s + 1));
		}

	}

	private int partition(int[] nums, int s, int end) {
		int pivot = nums[s];
		int i = s + 1;
		int j = end;
		while (i <= j) {
			while (i <= j && nums[i] <= pivot) {
				i++;
			}
			while (i <= j && nums[j] > pivot) {
				j--;
			}
			if(i <= j) {
				swap(nums, i, j);
			}
		}
		swap(nums, s, j);
		return j;
	}

	private void swap(int[] nums, int i, int j) {
		int swap_temp = nums[i];
		nums[i] = nums[j];
		nums[j] = swap_temp;
	}
}
