package easy;

/**
 * 公交站间的距离
 * <p>
 * 环形公交路线上有 n 个站，按次序从 0 到 n - 1 进行编号。我们已知每一对相邻公交站之间的距离，distance[i] 表示编号为 i 的车站和编号为 (i + 1) % n 的车站之间的距离。
 * 环线上的公交车都可以按顺时针和逆时针的方向行驶。
 * 返回乘客从出发点 start 到目的地 destination 之间的最短距离。
 *
 * @author jd95288
 * @date 2024-09-16 20:08
 */
public class DistanceBetweenBusStops1184 {

    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int n = distance.length;
        int s = Math.min(start, destination);
        int e = Math.max(start, destination);
        int d1 = 0, d2 = 0;
        for (int i = 0; i < n; i++) {
            if (i < s || i >= e) {
                d1 += distance[i];
            } else {
                d2 += distance[i];
            }
        }
        return Math.min(d1, d2);
    }
}
