package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 分割回文串
 * <p>
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 *
 * @author jd95288
 * @date 2025-03-01 20:16
 */
public class Partition131 {

    public List<List<String>> partition(String s) {
        int n = s.length();
        List<List<String>>[] dp = new List[n];
        for (int i = 0; i < n; i++) {
            dp[i] = new ArrayList<>();
        }
        char[] chars = s.toCharArray();
        dp[0].add(new ArrayList<>());
        dp[0].get(0).add((String.valueOf(chars[0])));
        for (int i = 1; i < n; i++) {
            dp[i] = new ArrayList<>();
            for (List<String> list : dp[i - 1]) {
                List<String> tmp = new ArrayList<>(list);
                tmp.add(String.valueOf(chars[i]));
                dp[i].add(tmp);
                String last = String.valueOf(chars[i]);
                if (list.get(list.size() - 1).equals(last)) {
                    tmp = new ArrayList<>(list.subList(0, list.size() - 1));
                    tmp.add(list.get(list.size() - 1) + last);
                    dp[i].add(tmp);
                }
                if (list.size() > 1 && list.get(list.size() - 2).equals(last)) {
                    tmp = new ArrayList<>(list.subList(0, list.size() - 2));
                    tmp.add(list.get(list.size() - 2) + list.get(list.size() - 1) + last);
                    dp[i].add(tmp);
                }
            }
        }
        return dp[n - 1];
    }

}
