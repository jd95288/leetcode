package easy;

/**
 * 赎金信
 * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 * 如果可以，返回 true ；否则返回 false 。
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 *
 * @author jd95288
 * @date 2024-03-23 21:27
 */
public class CanConstruct383 {

    public boolean canConstruct(String ransomNote, String magazine) {
        char[] chars = magazine.toCharArray();
        int[] charsNum = new int[26];
        for (char c : chars) {
            charsNum[c - 97] += 1;
        }
        for (char c : ransomNote.toCharArray()) {
            int i = c - 97;
            if (--charsNum[i] < 0) {
                return false;
            }
        }
        return true;
    }
}
