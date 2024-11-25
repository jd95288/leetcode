package hard;

import java.util.*;

/**
 * 最小区间
 * <p>
 * 你有 k 个 非递减排列 的整数列表。找到一个 最小 区间，使得 k 个列表中的每个列表至少有一个数包含在其中。
 * 我们定义如果 b-a < d-c 或者在 b-a == d-c 时 a < c，则区间 [a,b] 比 [c,d] 小。
 *
 * @author jd95288
 * @date 2024-11-24 15:14
 */
public class SmallestRange632 {

    public int[] smallestRange(List<List<Integer>> nums) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            for (Integer num : nums.get(i)) {
                list.add(new int[]{num, i});
            }
        }
        int[] res = new int[]{0, 1000000};
        list.sort((a, b) -> a[0] - b[0]);
        int n = list.size(), k = nums.size();
        int l = 0;
        int[] typeMaxIndex = new int[k];
        Arrays.fill(typeMaxIndex, -1);
        int types = 0;
        for (int r = 0; r < n; r++) {
            int[] e = list.get(r);
            int right = e[0];
            int type = e[1];
            int lastTypeMaxIndex = typeMaxIndex[type];
            typeMaxIndex[type] = r;
            if (lastTypeMaxIndex < l){
                types++;
            }
            while (types == k) {
                int[] left = list.get(l);
                int lType = left[1];
                if (typeMaxIndex[lType] == l++) {
                    types--;
                    if (right - left[0] < res[1] - res[0]) {
                        res[0] = left[0];
                        res[1] = right;
                    }
                }
            }
        }
        return res;
    }

}
