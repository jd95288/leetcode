package hard;

import java.util.Arrays;

/**
 * 最近的房间
 * <p>
 * 有一个数组 rooms，rooms[i][0] 表示第 i 个房间编号，房间编号不重复，rooms[i][1] 表示第 i 个房间大小。
 * 有一个查询数组 queries，queries[j][0] 表示第 j 个查询期望的房间大小，
 * queries[j][1] 表示第 j 个查询最低的房间大小。
 * 返回查询数组对应的结果数组，查询结果为房间编号，该房间的面积至少为 queries[j][1]，且与 queries[j][0] 的距离最小，
 * 如果存在距离相等的情况，取房间编号最小的。
 *
 * @author jd95288
 * @date 2024-12-16 16:23
 */
public class ClosestRoom1847 {

    public int[] closestRoom(int[][] rooms, int[][] queries) {
        Arrays.sort(rooms, (a, b) -> {
            int compare = a[1] - b[1];
            if (compare != 0) {
                return compare;
            }
            return a[0] - b[0];
        });
        int n = rooms.length;
        int k = queries.length;
        int[] res = new int[k];
        int i = 0;
        for (int[] query : queries) {
            int minAreaRoomIndex = lowerBound(rooms, 0, n - 1, query[1]);
            if (minAreaRoomIndex == n) {
                res[i++] = -1;
                continue;
            }
            int dist = Integer.MAX_VALUE;
            int roomId = Integer.MAX_VALUE;
            for (int j = minAreaRoomIndex; j < n; j++) {
                int tmp = Math.abs(query[0] - rooms[j][0]);
                if (tmp < dist) {
                    dist = tmp;
                    roomId = rooms[j][0];
                } else if (tmp == dist) {
                    roomId = Math.min(rooms[j][0], roomId);
                }
            }
            res[i++] = roomId;
        }

        return res;
    }

    public int lowerBound(int[][] rooms, int l, int r, int target) {
        int m = l + ((r - l) >> 1);
        while (l <= r) {
            if (rooms[m][1] >= target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
            m = l + ((r - l) >> 1);
        }
        return l;
    }

}
