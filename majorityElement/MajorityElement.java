/**
 * @author liunian
 *
 * 2015/06/29
 *
 * 寻找众数
 * 众数： 大小为n数组的数组中，出现次数超过 ⌊ n/2 ⌋ 的数
 *
 * 举例： 数组为:[1, 3, 4, 3, 3, 5, 0, 3, 3]
 *       众数为： 3
 *       因为数组大小为9，3出现测次数为5 > ⌊ 9/2 ⌋
 *
 *       数组为：[1, 3, 4, 3, 5, 0, 4]
 *       不存在众数
 *
 */
public class MajorityElement {

    /**
     * 寻找众数
     * @param nums 数组不为空，且一定存在众数
     * @return
     */
    public int majorityElement(int[] nums) {
        int cur = nums[0];
        int cnt = 0;
        for(int i = 0; i < nums.length; i++) {
           if(cnt == 0) {
               cur = nums[i];
               cnt = 1;
           } else {
               if(cur == nums[i]) {
                   ++cnt;
               } else {
                   --cnt;
               }
           }
        }
        return cur;
    }
}
