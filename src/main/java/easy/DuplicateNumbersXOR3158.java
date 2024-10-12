package easy;


/**
 * 求出出现两次数字的XOR值
 * <p>
 * 给你一个数组 nums ，数组中的数字 要么 出现一次，要么 出现两次。
 * 请你返回数组中所有出现两次数字的按位 XOR 值，如果没有数字出现过两次，返回 0 。
 *
 * @author jd95288
 * @date 2024-10-12 8:46
 */
public class DuplicateNumbersXOR3158 {

    public int duplicateNumbersXOR(int[] nums) {
        boolean[] seen = new boolean[51];
        int res = 0;
        for (int num : nums) {
            if (seen[num]) {
                res ^= num;
            } else {
                seen[num] = true;
            }
        }
        return res;
    }

}
