package legacy;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 * <p>
 * 输入：s = "cbbd"
 * 输出："bb"
 * 示例 3：
 * <p>
 * 输入：s = "a"
 * 输出："a"
 * 示例 4：
 * <p>
 * 输入：s = "ac"
 * 输出："a"
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母（大写和/或小写）组成
 *
 * @author liyang
 * @date 2021-12-15 15:20
 */
public class LongestPalindrome {

    /*自己写的实质上就是所谓的中心扩展法 只不过建立的模型是需要三个字符的，逻辑不够清晰也更加复杂，抽象的不够*/
    public static String longestPalindrome(String s) {
//        Map<Character, Integer> indexMap = new HashMap<>(s.length());
        if (s.length() == 1) {
            return s;
        }
        if (s.length() == 2) {
            Character f = s.charAt(0);
            Character l = s.charAt(1);
            if (f.equals(l)) {
                return s;
            } else {
                return s.substring(0, 1);
            }
        }
        //Stack<Character> stack = new Stack<>();
        //第三次没有考虑至少有一个的情况
        String result = s.substring(0,1);
        //Character last = null;
        for (int i = 1; i < s.length() - 1; i++) {
            int j = i + 1;
            int k = i - 1;
            //char p = s.charAt(k);
            //char m = s.charAt(i);
            //char n = s.charAt(j);

            if (s.charAt(k) == s.charAt(i)) {
                /* 第一次没有考虑中间连续相同的情况*/
                while (j < s.length() && s.charAt(i) == s.charAt(j)) {
                    j++;
                }
/*                while (k >= 1 && j < s.length() && s.charAt(s.charAt(k) == s.charAt(i) ? k - 1 : k) == s.charAt(j)) {
                    k--;
                    j++;
                }*/
                while (k >= 1 && j < s.length() && s.charAt(k - 1) == s.charAt(j)) {
                    k--;
                    j++;
                }
/*                if (s.charAt(Math.max(0, k - 1)) == s.charAt(j) && j - k + 1 > result.length()) {
                    result = s.substring(Math.max(k - 1, 0), j);
                } else */
                if (j - k > result.length()) {
                    result = s.substring(k, j);
                }
            } else if (s.charAt(i) == s.charAt(j)) {
                /* 第二次没有考虑这个的条件*/
                while (j < s.length() && s.charAt(i) == s.charAt(j)) {
                    j++;
                }
                while (k >= 0 && j < s.length() && s.charAt(k) == s.charAt(j)) {
                    k--;
                    j++;
                }
                //这里的条件是不包括k的因此，应该为是j-k而不是j-k+1
                if (j - k -1> result.length()) {
                    result = s.substring(k+1, j);
                }
            } else if (s.charAt(k) == s.charAt(j)) {
                while (k >= 1 && j < s.length() - 1 && s.charAt(k - 1) == s.charAt(j + 1)) {
                    k--;
                    j++;
                }
                if (j - k + 1 > result.length()) {
                    result = s.substring(k, j + 1);
                }
            }

            /*            Integer index = indexMap.putIfAbsent(c, i);
            if (index != null) {
                result = s.substring(index, i + 1);
            }*/
        }

        return result;
    }

    /** 标准答案 动态规划
    * 时间复杂度： O(n^2) 两个for循环
    * 空间复杂度： O(n^2) dp数组的大小
    * */
    public String longestPalindromeNew(String s) {
        int len = s.length();
        // 特判
        if (len < 2){
            return s;
        }

        int maxLen = 1;
        int begin  = 0;

        // 1. 状态定义
        // dp[i][j] 表示s[i...j] 是否是回文串


        // 2. 初始化
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] chars = s.toCharArray();
        // 3. 状态转移
        // 注意：先填左下角
        // 填表规则：先一列一列的填写，再一行一行的填，保证左下方的单元格先进行计算
        for (int j = 1;j < len;j++){
            for (int i = 0; i < j; i++) {
                // 头尾字符不相等，不是回文串
                if (chars[i] != chars[j]){
                    dp[i][j] = false;
                }else {
                    // 相等的情况下
                    // 考虑头尾去掉以后没有字符剩余，或者剩下一个字符的时候，肯定是回文串
                    if (j - i < 3){
                        dp[i][j] = true;
                    }else {
                        // 状态转移
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要dp[i][j] == true 成立，表示s[i...j] 是否是回文串
                // 此时更新记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen){
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        // 4. 返回值
        return s.substring(begin,begin + maxLen);
    }

    /**网友提供的中心扩展*/
    public static String longestPalindrome1(String s) {
        char[] charArray = s.toCharArray();
        int maxLeft = 0, maxRight = -1;
        for (int i = 0; i < charArray.length; ++i) {
            int left = i, right = i;
            while (left >= 0 && charArray[left] == charArray[i]) {
                --left;
            }
            while (right <= charArray.length - 1 && charArray[right] == charArray[i]) {
                ++right;
            }
            while (left >= 0 && right <= charArray.length - 1 && charArray[left] == charArray[right]) {
                --left;
                ++right;
            }
            if (maxRight - maxLeft < right - left) {
                maxLeft = left;
                maxRight = right;
            }
        }
        //最后改为Math.min(maxRight,s.length())
        return s.substring(maxLeft + 1, Math.min(maxRight,s.length()));
    }





    /** 标准答案 中心扩展
     * 时间复杂度： O(n^2) 两个for循环
     * 空间复杂度： O(1) 不需要额外的空间
     * */
    public String longestPalindromeNew2(String s) {
        if (s == null || s.length() < 1){
            return "";
        }

        // 初始化最大回文子串的起点和终点
        int start = 0;
        int end   = 0;

        // 遍历每个位置，当做中心位
        for (int i = 0; i < s.length(); i++) {
            // 分别拿到奇数偶数的回文子串长度
            int len_odd = expandCenter(s,i,i);
            int len_even = expandCenter(s,i,i + 1);
            // 对比最大的长度
            int len = Math.max(len_odd,len_even);
            // 计算对应最大回文子串的起点和终点
            if (len > end - start){
                start = i - (len - 1)/2;
                end = i + len/2;
            }
        }
        // 注意：这里的end+1是因为 java自带的左闭右开的原因
        return s.substring(start,end + 1);
    }


    /**
     *
     * @param s             输入的字符串
     * @param left          起始的左边界
     * @param right         起始的右边界
     * @return              回文串的长度
     */
    private int expandCenter(String s,int left,int right){
        // left = right 的时候，此时回文中心是一个字符，回文串的长度是奇数
        // right = left + 1 的时候，此时回文中心是一个空隙，回文串的长度是偶数
        // 跳出循环的时候恰好满足 s.charAt(left) ！= s.charAt(right)
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        // 回文串的长度是right-left+1-2 = right - left - 1
        return right - left - 1;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome1("cccc"));
    }
}
