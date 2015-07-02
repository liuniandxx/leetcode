import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @author liunian 
 * 2015/07/02
 * 
 * 判断数组是否包含重复元素
 * 
 * 思路： 使用hash进行判断
 *
 */
public class ContainsDuplicate {
	public boolean containsDuplicate(int[] nums) {
		if(nums == null || nums.length < 2) {
			return false;
		}
		
		Set<Integer> set = new HashSet<Integer>();
		for(int i = 0; i < nums.length; i++) {
			if(set.contains(nums[i])) {
				return true;
			} else {
				set.add(nums[i]);
			}
		}
				
		return false;
	}
}
