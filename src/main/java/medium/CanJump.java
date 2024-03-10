package medium;

/**
 * 跳跃游戏
 * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
 *
 * @author jd95288
 * @date 2024-03-07 14:57
 */
public class CanJump {

    public boolean canJump(int[] nums) {
        int dest = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] + i >= dest) {
                dest = i;
            }
        }
        return dest == 0;
    }

}
