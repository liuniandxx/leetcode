/**
 * Created by liunian on 15-10-20.
 * 思路: 动态规划: robs[i] = max(robs[i - 2] + nums[i], robs[i])
 */
public class HouseRobber {
    public static int rob(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        if(nums.length == 1) {
            return nums[0];
        }

        if(nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] robs = new int[nums.length];
        robs[0] = nums[0];
        robs[1] = Math.max(nums[0], nums[1]);

        for(int i = 2; i < nums.length; i++) {
            if(robs[i - 2] + nums[i] > robs[i - 1]) {
                robs[i] = robs[i - 2] + nums[i];
            } else {
                robs[i] = robs[i - 1];
            }
        }
        return robs[nums.length - 1];
    }

    public static void main(String[] args) {
            int[] nums = {};
        System.out.println(nums.length);
//        System.out.println(rob());
    }
}
