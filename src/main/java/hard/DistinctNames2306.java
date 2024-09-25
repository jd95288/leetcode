package hard;

import java.util.*;

/**
 * 公司命名
 * <p>
 * 给你一个字符串数组 ideas 表示在公司命名过程中使用的名字列表。公司命名流程如下：
 * 从 ideas 中选择 2 个 不同 名字，称为 ideaA 和 ideaB 。
 * 交换 ideaA 和 ideaB 的首字母。
 * 如果得到的两个新名字 都 不在 ideas 中，那么 ideaA ideaB（串联 ideaA 和 ideaB ，中间用一个空格分隔）是一个有效的公司名字。
 * 否则，不是一个有效的名字。
 * <p>
 * 返回 不同 且有效的公司名字的数目。
 *
 * @author jd95288
 * @date 2024-09-25 10:42
 */
public class DistinctNames2306 {

    public long distinctNames(String[] ideas) {
        long res = 0L;
        int n = ideas.length;
        Map<String, Set<Integer>> suffixToFirstMap = new HashMap<>();
        List<String>[] words = new List[26];
        for (int i = 0; i < n; i++) {
            String idea = ideas[i];
            int first = idea.charAt(0) - 'a';
            if (words[first] == null) {
                words[first] = new ArrayList<>();
            }
            words[first].add(idea);
            String suffix = idea.substring(1);
            suffixToFirstMap.putIfAbsent(suffix, new HashSet<>());
            suffixToFirstMap.get(suffix).add(first);
        }
        int[][] cannotCombine = new int[26][26];
        for (int i = 0; i < 26; i++) {
            if (words[i] == null) {
                continue;
            }
            for (String word : words[i]) {
                String suffix = word.substring(1);
                Set<Integer> set = suffixToFirstMap.get(suffix);
                if (set != null){
                    for (Integer index : set) {
                        cannotCombine[i][index]++;
                    }
                }
            }
        }

        for (int i = 0; i < 26; i++) {
            List<String> iWord = words[i];
            if (iWord == null) {
                continue;
            }
            for (int j = 0; j < iWord.size(); j++) {
                String word = iWord.get(j);
                String suffix = word.substring(1);
                for (int k = i + 1; k < 26; k++) {
                    Set<Integer> set = suffixToFirstMap.get(suffix);
                    if (set != null && words[k] != null && !set.contains(k)) {
                        res += 2 * (words[k].size() - cannotCombine[k][i]);
                    }
                }
            }
        }
        return res;
    }

}
