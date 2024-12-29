package medium;

import java.util.PriorityQueue;

/**
 * 通过投票对团队排名
 * <p>
 * 投票人对所有团队的排名用一个字符串 votes[i] 表示，团队的先后顺序就代表排名。
 * 根据所有投票人的排名对团队排名，排名第一次数最多的为第一名，如果相同则根据排名第二的次数，
 * 以此类推，如果最终都相同，则以团队名在字母表的先后顺序排名。
 *
 * @author jd95288
 * @date 2024-12-29 18:36
 */
public class RankTeams1366 {

    public static class Rank {
        public int name;
        public int[] cnt;

        public Rank(int name, int[] cnt) {
            this.name = name;
            this.cnt = cnt;
        }
    }

    public String rankTeams(String[] votes) {
        int n = votes[0].length();
        PriorityQueue<Rank> q = new PriorityQueue<>((a, b) -> {
            int[] cnta = a.cnt;
            int[] cntb = b.cnt;
            int i = 0;
            while (i < n && cnta[i] == cntb[i]) {
                i++;
            }
            if (i == n) {
                return a.name - b.name;
            }
            return cntb[i] - cnta[i];
        });

        int[][] cnt = new int[26][n];
        for (String vote : votes) {
            for (int i = 0; i < vote.length(); i++) {
                int c = vote.charAt(i) - 'A';
                cnt[c][i]++;
            }
        }
        for (int i = 0; i < 26; i++) {
            q.offer(new Rank(i, cnt[i]));
        }
        char[] chars = new char[n];
        int i = 0;
        while (i < n) {
            chars[i++] = (char) (q.poll().name + (int) 'A');
        }
        return new String(chars);
    }

}
