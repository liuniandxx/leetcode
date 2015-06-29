import java.util.ArrayList;
import java.util.List;

/**
 * @author liunian
 * 2015/06/29
 *
 * 寻找众数
 *
 * 众数定义为：大小为n的数组，出现次数大于超过⌊ n/3 ⌋ 的数
 *
 * 提示： 这样的数最多只有两个
 *
 * 主要思想：假设数组nums 中存在两个众数num1和num2
 * 那么num1 和num2 出现次数减去其他数出现的次数将 > 0
 * 我们最后对留下的num1 和 num2 进行一下检查就可以了
 *
 * (同理可以推广到n个数的情况)
 */
public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();

        int num1 = 0;
        int num2 = 0;
        int count1 = 0;
        int count2 = 0;

        for(int i = 0; i < nums.length; i++) {
            if(count1 == 0) {
                num1 = nums[i];
            }

            if(count2 == 0 && nums[i] != num1) {
                num2 = nums[i];
            }

            if(nums[i] == num1) {
                ++count1;
            }

            if(nums[i] == num2) {
                ++count2;
            }

            if(count1 != 0 && count2 != 0 &&
                    nums[i] != num1 && nums[i] != num2) {
                --count1;
                --count2;
            }
        }

        if(isMoreThanOneThird(num1, nums)) {
            res.add(num1);
        }

        if(num1 != num2 && isMoreThanOneThird(num2, nums)) {
            res.add(num2);
        }

        return res;
    }


    private boolean isMoreThanOneThird(int cur, int[] nums) {
        int cnt = 0;
        for(int i = 0; i < nums.length; i++) {
            if(cur == nums[i]) {
                cnt++;
            }
        }

        return cnt > nums.length / 3;
    }
}
