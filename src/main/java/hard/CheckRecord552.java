package hard;

/**
 * 学生出勤记录 II
 * <p>
 * 可以用字符串表示一个学生的出勤记录，其中的每个字符用来标记当天的出勤情况（缺勤、迟到、到场）。记录中只含下面三种字符：
 * 'A'：Absent，缺勤
 * 'L'：Late，迟到
 * 'P'：Present，到场
 * 如果学生能够 同时 满足下面两个条件，则可以获得出勤奖励：
 * <p>
 * 按 总出勤 计，学生缺勤（'A'）严格 少于两天。
 * 学生 不会 存在 连续 3 天或 连续 3 天以上的迟到（'L'）记录。
 * 给你一个整数 n ，表示出勤记录的长度（次数）。请你返回记录长度为 n 时，可能获得出勤奖励的记录情况 数量 。
 * 答案可能很大，所以返回对 10^9 + 7 取余 的结果。
 *
 * @author jd95288
 * @date 2024-08-19 9:53
 */
public class CheckRecord552 {
    private static final int MOD = 1000000007;
    public int checkRecord(int n) {
        if (n == 1) {
            return 3;
        }
        long[][][] dp = new long[n][2][3];
        dp[0][0][0] = 1;
        dp[0][0][1] = 1;
        dp[0][0][2] = 1;

        dp[1][0][0] = 2;
        dp[1][0][1] = 2;
        dp[1][0][2] = 2;
        dp[1][1][0] = 1;
        dp[1][1][1] = 1;

        for (int i = 2; i < n; i++) {
            int pre = i - 1;
            int prepre = i - 2;
            dp[i][0][0] = (dp[prepre][0][0] + 2 * dp[prepre][0][1]) % MOD;
            dp[i][0][1] = (dp[pre][0][0] + dp[pre][0][1]) % MOD;
            dp[i][0][2] = (dp[pre][0][0] + dp[pre][0][1]) % MOD;
            dp[i][1][0] = (dp[prepre][1][0] + 2 * dp[prepre][1][1] + 2 * dp[prepre][0][2] + dp[pre][0][2]) % MOD;
            dp[i][1][1] = (dp[pre][1][0] + dp[pre][1][1] + dp[pre][0][2]) % MOD;
        }
        return (int) ((dp[n - 1][0][0] + dp[n - 1][0][1] + dp[n - 1][0][2] + dp[n - 1][1][0] + dp[n - 1][1][1]) % MOD);
    }

}
