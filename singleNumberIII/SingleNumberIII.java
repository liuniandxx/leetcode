/**
 * Created by liunian on 15-10-30.
 * 题目： 在一组数据中有两个数字出现了一次，
 * 其他数据都出现了两次，找出出现两次的数字
 * 思路: 首先考虑，在一组数据中，只有一个数字出现了一个，
 * 其他数据都出现了两次，找出出现一次的数据 -> 直接异或运算就可
 * 
 * 两个数的情况，首先要将数组分成两组，出现一次的数字分到都不同，其他相同的
 * 都分配到同一组，这样 按照 上面思路求解就可
 *  
 * 怎么分组： 首先异或求解所有数字，然后将所得数字（肯定不是0），找出其不是0的二进制位，
 * 将 数据 分成 该二进制为0 和 不为0 的两组就可
 */
public class SingleNumberIII {
    public int [] singleNumber(int[] nums) {
        long orSum = nums[0];

        for(int i = 1; i < nums.length; i++) {
            orSum = orSum ^ nums[i];
        }

        long k = 1;
        while ((k & orSum) == 0) {
            k <<= 1;
        }

        int first = 0;
        for(int i = 0; i < nums.length; i++) {
            if((k & nums[i]) != 0) {
                first = first ^ nums[i];
            }
        }

        int second = 0;
        for(int i = 0; i < nums.length; i++) {
            if((k & nums[i]) == 0) {
                second = second ^ nums[i];
            }
        }
        return new int[] {first, second};
    }


    public static void main(String[] args) {
        SingleNumberIII singleNumberIII = new SingleNumberIII();
        int[] nums = new int[] {1, 2, 1, 3, 2, 5};
        int[] res = singleNumberIII.singleNumber(nums);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }
}
