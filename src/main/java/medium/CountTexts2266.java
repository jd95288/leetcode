package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 统计打字方案数
 *
 * Alice 在给 Bob 用手机打字。数字到字母的 对应 如下图所示。
 * 为了 打出 一个字母，Alice 需要 按 对应字母 i 次，i 是该字母在这个按键上所处的位置。
 * - 比方说，为了按出字母 's' ，Alice 需要按 '7' 四次。类似的， Alice 需要按 '5' 两次得到字母  'k' 。
 * - 注意，数字 '0' 和 '1' 不映射到任何字母，所以 Alice 不 使用它们。
 * 但是，由于传输的错误，Bob 没有收到 Alice 打字的字母信息，反而收到了 按键的字符串信息 。
 * - 比方说，Alice 发出的信息为 "bob" ，Bob 将收到字符串 "2266622" 。
 * 给你一个字符串 pressedKeys ，表示 Bob 收到的字符串，请你返回 Alice 总共可能发出多少种文字信息 。
 * 由于答案可能很大，将它对 10^9 + 7 取余 后返回。
 *
 * @author jd95288
 * @date 2025-01-19 2:21
 */
public class CountTexts2266 {

    static int[] dp3 = new int[100001];
    static int[] dp4 = new int[100001];
    static int MOD = 1000000007;
    static Map<Character, int[]> map = new HashMap<>();

    static {
        dp3[1] = 1;
        dp3[2] = 2;
        dp3[3] = 4;
        dp3[4] = 7;
        dp4[1] = 1;
        dp4[2] = 2;
        dp4[3] = 4;
        dp4[4] = 8;
        for (int i = 5; i < 100001; i++) {
            dp3[i] = ((dp3[i - 1] + dp3[i - 2]) % MOD + dp3[i - 3] % MOD) % MOD;
            dp4[i] = ((dp4[i - 1] + dp4[i - 2]) % MOD + (dp4[i - 3] + dp4[i - 4]) % MOD) % MOD;
        }
        map.put('2', dp3);
        map.put('3', dp3);
        map.put('4', dp3);
        map.put('5', dp3);
        map.put('6', dp3);
        map.put('8', dp3);
        map.put('7', dp4);
        map.put('9', dp4);
    }

    public int countTexts(String pressedKeys) {
        char[] chars = pressedKeys.toCharArray();
        char prev = chars[0];
        int cnt = 1;
        long res = 1;
        for (int i = 1; i < chars.length; i++) {
            if (prev == chars[i]) {
                cnt++;
            } else {
                res = res * map.get(prev)[cnt] % MOD;
                prev = chars[i];
                cnt = 1;
            }
        }
        if (cnt > 1){
            res = res * map.get(prev)[cnt] % MOD;
        }
        return (int) res;
    }

}
