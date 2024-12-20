package medium;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 同位字符串连接的最小长度
 *
 * @author jd95288
 * @date 2024-12-20 9:08
 */
public class MinAnagramLength3138 {

    public int minAnagramLength_v1(String s) {
        int n = s.length();
        int[] cnt = new int[26];
        Map<Integer, int[]> possibleLength = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            cnt[c]++;
            int length = i + 1;
            if (n % length == 0) {
                int[] composition = new int[26];
                System.arraycopy(cnt, 0, composition, 0, 26);
                possibleLength.put(length, composition);
            }
        }
        char[] chars = s.toCharArray();
        for (Map.Entry<Integer, int[]> entry : possibleLength.entrySet()) {
            int length = entry.getKey();
            if (length == n) {
                return n;
            }
            int[] composition = entry.getValue();
            int loop = n / length;
            boolean find = true;
            here:
            for (int i = 0; i < loop; i++) {
                int[] tmp = new int[26];
                System.arraycopy(composition, 0, tmp, 0, 26);
                for (int j = 0; j < length; j++) {
                    int c = chars[i * length + j] - 'a';
                    tmp[c]--;
                    if (tmp[c] < 0) {
                        find = false;
                        break here;
                    }
                }
            }
            if (find) {
                return length;
            }
        }
        return n;
    }

}
