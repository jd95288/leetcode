package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 从盒子中找出字典序最大的字符串 I
 * <p>
 * 给你一个字符串 word 和一个整数 numFriends。
 * Alice 正在为她的 numFriends 位朋友组织一个游戏。游戏分为多个回合，在每一回合中：
 * word 被分割成 numFriends 个 非空 字符串，且该分割方式与之前的任意回合所采用的都 不完全相同 。
 * 所有分割出的字符串都会被放入一个盒子中。
 * 在所有回合结束后，找出盒子中 字典序最大的 字符串。
 *
 * @author jd95288
 * @date 2025-06-04 9:19
 */
public class AnswerString3403 {

    public String answerString(String word, int numFriends) {
        if (numFriends == 1) {
            return word;
        }
        int n = word.length();
        List<Integer>[] chars = new ArrayList[26];
        Arrays.setAll(chars, x -> new ArrayList<>());
        for (int i = 0; i < n; i++) {
            char c = word.charAt(i);
            chars[c - 'a'].add(i);
        }
        int l = n - numFriends + 1;
        String[] strs = null;
        for (int i = 25; i >= 0; i--) {
            if (chars[i].size() > 0) {
                strs = new String[chars[i].size()];
                for (int j = 0; j < chars[i].size(); j++) {
                    int index = chars[i].get(j);
                    strs[j] = word.substring(index, Math.min(index + l, n));
                }
                break;
            }
        }
        Arrays.sort(strs);
        return strs[strs.length - 1];
    }

}
