import java.util.ArrayList;
import java.util.List;


/**
 * @author liunian 
 * 2015/06/30
 *
 * 总结范围
 * 
 * 题目意思是给定一个数组，求数组中表示的数字的范围，
 * 如果范围中有多个数字使用 -> 表示
 * 举例： 
 * 1.数组[0,1,2,3,5,6,8]
 *   总结范围为： [0->3, 5 ->6, 8]
 * 
 * 2.数组[5, 7]
 *   总结范围为:  [5,7]
 */
public class SummaryRanges {
	public List<String> summaryRange(int[] nums) {
		if(nums == null || nums.length <= 0) {
			return new ArrayList<String>();
		}
		
		List<String> res = new ArrayList<String>();
		
		int i = 0;
		while(i < nums.length) {
			int start = nums[i];
			int end = nums[i];
			while(i + 1 < nums.length && nums[i] + 1== nums[i + 1]) {
				end++;
				i++;
			} 
			
			if(start == end) {
				res.add(start + "");
			} else {
				res.add(start + "->" + end);
			}
			i++;
		}
		return res;
	}
}
