package medium;

import java.util.*;

/**
 * 需要教语言的最少人数
 * <p>
 * 在一个由 m 个用户组成的社交网络里，我们获取到一些用户之间的好友关系。两个用户之间可以相互沟通的条件是他们都掌握同一门语言。
 * 给你一个整数 n ，数组 languages 和数组 friendships ，它们的含义如下：
 * 总共有 n 种语言，编号从 1 到 n 。
 * languages[i] 是第 i 位用户掌握的语言集合。
 * friendships[i] = [u​​​​​​i​​​, v​​​​​​i] 表示 u​​​​​​​​​​​i​​​​​ 和 vi 为好友关系。
 * 你可以选择 一门 语言并教会一些用户，使得所有好友之间都可以相互沟通。请返回你 最少 需要教会多少名用户。
 * 请注意，好友关系没有传递性，也就是说如果 x 和 y 是好友，且 y 和 z 是好友， x 和 z 不一定是好友。
 *
 * @author jd95288
 * @date 2025-09-10 8:49
 */
public class MinimumTeachings1733 {

    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        int m = languages.length;
        int[] cnt = new int[n + 1];
        HashSet<Integer>[] lang = new HashSet[m + 1];
        Arrays.setAll(lang, x -> new HashSet<>());
        for (int i = 0; i < m; i++) {
            for (int language : languages[i]) {
                lang[i + 1].add(language);
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int[] friendship : friendships) {
            int a = friendship[0];
            int b = friendship[1];
            HashSet<Integer> tmp = new HashSet<>(lang[a]);
            tmp.retainAll(lang[b]);
            if (tmp.size() == 0) {
                if (!set.contains(a)) {
                    for (Integer t : lang[a]) {
                        cnt[t]++;
                    }
                    set.add(a);
                }
                if (!set.contains(b)) {
                    for (Integer t : lang[b]) {
                        cnt[t]++;
                    }
                    set.add(b);
                }
            }
        }
        return set.size() - Arrays.stream(cnt).max().orElse(0);
    }

}
