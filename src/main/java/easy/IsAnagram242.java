package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 有效的字母异位词
 * <p>
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 *
 * @author jd95288
 * @date 2024-07-20 23:41
 */
public class IsAnagram242 {
    /**
     * 执行通过
     */
    public boolean isAnagram(String s, String t) {
        int sl = s.length();
        int tl = t.length();
        if (sl != tl) {
            return false;
        }
        Map<Character, Integer> smap = new HashMap<>();
        Map<Character, Integer> tmap = new HashMap<>();
        for (int i = 0; i < sl; i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            smap.merge(sc, 1, Integer::sum);
            tmap.merge(tc, 1, Integer::sum);
        }
        for (Map.Entry<Character, Integer> entry : smap.entrySet()) {
            char key = entry.getKey();
            int value = entry.getValue();
            if (tmap.get(key) == null || tmap.get(key) != value) {
                return false;
            }
        }
        return true;
    }

}
