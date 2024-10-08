package easy;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 旅行终点站
 * <p>
 * 给你一份旅游线路图，该线路图中的旅行线路用数组 paths 表示，
 * 其中 paths[i] = [cityAi, cityBi] 表示该线路将会从 cityAi 直接前往 cityBi 。
 * 请你找出这次旅行的终点站，即没有任何可以通往其他城市的线路的城市。
 * 题目数据保证线路图会形成一条不存在循环的线路，因此恰有一个旅行终点站。
 *
 * @author jd95288
 * @date 2024-10-08 8:43
 */
public class DestCity1436 {

    public String destCity(List<List<String>> paths) {
        Set<String> start = new HashSet<>();
        for (List<String> path : paths) {
            start.add(path.get(0));
        }
        for (List<String> path : paths) {
            String dest = path.get(1);
            if (!start.contains(dest)) {
                return dest;
            }
        }
        return null;
    }
}
