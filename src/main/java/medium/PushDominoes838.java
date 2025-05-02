package medium;

import java.util.Arrays;

/**
 * 推多米诺
 * <p>
 * n 张多米诺骨牌排成一行，将每张多米诺骨牌垂直竖立。在开始时，同时把一些多米诺骨牌向左或向右推。
 * 每过一秒，倒向左边的多米诺骨牌会推动其左侧相邻的多米诺骨牌。同样地，倒向右边的多米诺骨牌也会推动竖立在其右侧的相邻多米诺骨牌。
 * 如果一张垂直竖立的多米诺骨牌的两侧同时有多米诺骨牌倒下时，由于受力平衡， 该骨牌仍然保持不变。
 * 就这个问题而言，我们会认为一张正在倒下的多米诺骨牌不会对其它正在倒下或已经倒下的多米诺骨牌施加额外的力。
 * 给你一个字符串 dominoes 表示这一行多米诺骨牌的初始状态，其中：
 * dominoes[i] = 'L'，表示第 i 张多米诺骨牌被推向左侧，
 * dominoes[i] = 'R'，表示第 i 张多米诺骨牌被推向右侧，
 * dominoes[i] = '.'，表示没有推动第 i 张多米诺骨牌。
 * 返回表示最终状态的字符串。
 *
 * @author jd95288
 * @date 2025-05-02 22:06
 */
public class PushDominoes838 {

    public String pushDominoes(String dominoes) {
        char[] chars = dominoes.toCharArray();
        int n = chars.length;
        int prevIndex = -1;
        char prev = 'L';
        char[] res = dominoes.toCharArray();
        for (int i = 0; i <= n; i++) {
            char cur;
            if (i == n) {
                cur = 'R';
            } else {
                cur = chars[i];
            }
            if (prev == 'R' && cur == 'L') {
                int cnt = (i - 1 - prevIndex) / 2;
                Arrays.fill(res, prevIndex + 1, prevIndex + cnt + 1, 'R');
                Arrays.fill(res, i - cnt, i, 'L');
            } else if (prev == cur) {
                Arrays.fill(res, prevIndex + 1, i, cur);
            }
            if (cur != '.') {
                prevIndex = i;
                prev = cur;
            }
        }
        return new String(res);
    }

}
