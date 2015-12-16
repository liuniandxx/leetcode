import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by liunian on 15-11-6.
 */
public class MinSizeSubSum {
    public static int minSubArrayLen(int s, int[] nums) {

        if(nums == null || nums.length <= 0) {
            return 0;
        }

        Queue<Integer> que = new LinkedList<Integer>();

        int index = 0;
        int resLen = Integer.MAX_VALUE;
        int sum = 0;
        while (index < nums.length  || s <= sum) {
            if(sum < s) {
                que.add(nums[index]);
                sum += nums[index];
                index++;
            } else {
                if(resLen > que.size()) {
                    resLen = que.size();
                }

                Integer head = que.remove();
                sum -= head;
            }
        }
        return resLen == Integer.MAX_VALUE ? 0 : resLen;
//        for(int i = 1; i < nums.length; i++) {
//            nums[i] += nums[i - 1];
//        }
//
//        int resLen = Integer.MAX_VALUE;
//
//        for(int i = 0; i < nums.length; i++) {
//            if(nums[i] < s) {
//                continue;
//            } else {
//                int start = 0;
//                int end = i;
//
//                int dis = nums[i] - s;
//                while(start <= end) {
//                    int mid = start + (end - start) / 2;
//
//                    if(nums[mid] > dis) {
//                        end = mid - 1;
//                    } else {
//                        start = mid + 1;
//                    }
//                }
//                if(resLen > i - start + 1) {
//                    resLen = i - start + 1;
//                }
//            }
//        }
//        return resLen;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 4, 4};
        System.out.println(minSubArrayLen(4, nums));
    }
}
