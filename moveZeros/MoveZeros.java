/**
 * Created by liunian on 15-10-9.
 */
public class MoveZeros {
    public static void moveZeroes(int[] nums) {
        if(nums == null || nums.length <= 1) {
            return;
        }

        int i = 0;
        int j = 0;

        int len = nums.length;

        while(i < len && j < len) {
            while (i < len && nums[i] != 0) {
                i++;
            }

            while (j < len && nums[j] == 0) {
                j++;
            }

            if(i < len && j < len && i < j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            } else {
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 0, 1};

        moveZeroes(nums);

        for(int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
}
