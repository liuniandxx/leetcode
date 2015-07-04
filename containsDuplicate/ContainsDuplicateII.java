import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 
 * @author liunian
 * 2015/07/04
 * 判断数组在长度为k+1的字段中是包含重复元素
 * 
 * 思路:
 * 判断重复使用hashset的数据结构,同时维护一个长度为k + 1的队列
 * 当队列中的元素没有k + 1时，直接将当前数加入队列中，
 * 当队列中的数达到k + 1时，将队列头部的数据从队列和hashset中移除
 * 同时判断当前数是否在hashset中，如果在，直接返回true
 * 如果不在，就将其分别加入到hashset和队列中
 */
public class ContainsDuplicateII {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		if(nums == null || nums.length < 2 || k < 1) {
			return false;
		}
		
		Set<Integer> set = new HashSet<Integer>();
		Queue<Integer> que = new LinkedList<Integer>();
		for(int i = 0; i < nums.length; i++) {
			if(que.size() > k) {
				Integer head = que.remove();
				set.remove(head);
			}
			if(set.contains(nums[i])) {
				return true;
			} else {
				set.add(nums[i]);
				que.add(nums[i]);
			}
		}
		return false;
	}
}
