package medium;


/**
 * 水果成篮 III
 *
 * 给你两个长度为 n 的整数数组，fruits 和 baskets，其中 fruits[i] 表示第 i 种水果的 数量，baskets[j] 表示第 j 个篮子的 容量。
 * 你需要对 fruits 数组从左到右按照以下规则放置水果：
 * 每种水果必须放入第一个 容量大于等于 该水果数量的 最左侧可用篮子 中。
 * 每个篮子只能装 一种 水果。
 * 如果一种水果 无法放入 任何篮子，它将保持 未放置。
 * 返回所有可能分配完成后，剩余未放置的水果种类的数量。
 *
 * @author jd95288
 * @date 2025-08-05 15:20
 */
public class NumOfUnplacedFruits3479 {

    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        int blockSize = (int) Math.ceil(Math.sqrt(n));
        int m = (int) Math.ceil((double) n / blockSize);
        int[] block = new int[m];
        int bi = 0;
        while (bi < m) {
            int start = bi * blockSize;
            int max = 0;
            for (int j = start; j < start + blockSize && j < n; j++) {
                max = Math.max(max, baskets[j]);
            }
            block[bi++] = max;
        }
        int res = n;
        for (int fruit : fruits) {
            int i = 0;
            for (; i < m; i++) {
                if (fruit <= block[i]) {
                    res--;
                    break;
                }
            }
            int start = i * blockSize;
            int newMax = 0;
            for (int j = start; j < start + blockSize && j < n; j++) {
                if (baskets[j] >= fruit) {
                    if (baskets[j] == block[i]) {
                        for (int k = j + 1; k < start + blockSize && k < n; k++) {
                            newMax = Math.max(newMax, baskets[k]);
                        }
                        block[i] = newMax;
                    }
                    baskets[j] = 0;
                    break;
                } else {
                    newMax = Math.max(newMax, baskets[j]);
                }
            }
        }
        return res;
    }

}
