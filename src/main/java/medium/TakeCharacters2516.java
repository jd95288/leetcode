package medium;

/**
 * 每种字符至少取 K 个
 * <p>
 * 给你一个由字符 'a'、'b'、'c' 组成的字符串 s 和一个非负整数 k 。
 * 每分钟，你可以选择取走 s 最左侧 还是 最右侧 的那个字符。
 * 你必须取走每种字符 至少 k 个，返回需要的 最少 分钟数；如果无法取到，则返回 -1 。
 *
 * @author jd95288
 * @date 2024-09-27 9:12
 */
public class TakeCharacters2516 {

    public int takeCharacters_v1(String s, int k) {
        if (k == 0) {
            return 0;
        }
        int res = Integer.MAX_VALUE;
        int[] cnt = new int[3];
        char[] chars = s.toCharArray();
        int n = chars.length;
        int l = n - 1;
        while (l >= 0 && (cnt[0] < k || cnt[1] < k || cnt[2] < k)) {
            cnt[chars[l--] - 'a']++;
        }
        if (cnt[0] < k || cnt[1] < k || cnt[2] < k) {
            return -1;
        }
        l++;
        int r = n;
        int doubleN = 2 * chars.length;
        for (; l <= n; l++) {
            while (r < doubleN && (cnt[0] < k || cnt[1] < k || cnt[2] < k)) {
                cnt[chars[r++ % n] - 'a']++;
            }
            res = Math.min(res, r - l);
            if (l == n) {
                break;
            }
            cnt[chars[l] - 'a']--;
        }
        return res;
    }

}
