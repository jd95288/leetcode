package medium;

/**
 * 从字符串中移除星号
 *
 * 给你一个包含若干星号 * 的字符串 s 。
 * <p>
 * 在一步操作中，你可以：
 * 选中 s 中的一个星号。
 * 移除星号 左侧 最近的那个 非星号 字符，并移除该星号自身。
 * <p>
 * 返回移除 所有 星号之后的字符串。
 * 注意：
 * 生成的输入保证总是可以执行题面中描述的操作。
 * 可以证明结果字符串是唯一的。
 *
 * @author jd95288
 * @date 2024-09-14 8:56
 */
public class RemoveStars2390 {

    public String removeStars(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int p = 0;
        for (int i = 0; i < n; i++) {
            if (chars[i] == '*') {
                p--;
            } else {
                chars[p++] = chars[i];
            }
        }
        return new String(chars, 0, p);
    }

}
