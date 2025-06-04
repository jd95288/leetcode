package medium;

import java.util.Arrays;

/**
 * 按字典序排列最小的等效字符串
 * <p>
 * 给出长度相同的两个字符串s1 和 s2 ，还有一个字符串 baseStr 。
 * 其中  s1[i] 和 s2[i]  是一组等价字符。
 * 举个例子，如果 s1 = "abc" 且 s2 = "cde"，那么就有 'a' == 'c', 'b' == 'd', 'c' == 'e'。
 * 等价字符遵循任何等价关系的一般规则：
 * 自反性 ：'a' == 'a'
 * 对称性 ：'a' == 'b' 则必定有 'b' == 'a'
 * 传递性 ：'a' == 'b' 且 'b' == 'c' 就表明 'a' == 'c'
 * 例如， s1 = "abc" 和 s2 = "cde" 的等价信息和之前的例子一样，那么 baseStr = "eed" , "acd" 或 "aab"，这三个字符串都是等价的，而 "aab" 是 baseStr 的按字典序最小的等价字符串
 * 利用 s1 和 s2 的等价信息，找出并返回 baseStr 的按字典序排列最小的等价字符串。
 *
 * @author jd95288
 * @date 2025-06-05 0:15
 */
public class SmallestEquivalentString1061 {

    public class UnionFind {
        private int[] father;

        public UnionFind() {
            this.father = new int[26];
            Arrays.setAll(father, i -> i);
        }

        public void merge(int a, int b) {
            int x = find(a);
            int y = find(b);
            if (x == y) {
                return;
            }
            if (x < y) {
                father[y] = x;
            } else {
                father[x] = y;
            }
        }

        public int find(int a) {
            if (father[a] != a) {
                father[a] = find(father[a]);
            }
            return father[a];
        }
    }

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int n = s1.length();
        UnionFind uf = new UnionFind();
        for (int i = 0; i < n; i++) {
            uf.merge(s1.charAt(i) - 'a', s2.charAt(i) - 'a');
        }
        StringBuilder sb = new StringBuilder();
        for (char c : baseStr.toCharArray()) {
            sb.append((char) ('a' + uf.find(c - 'a')));
        }
        return sb.toString();
    }

}
