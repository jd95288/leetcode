package medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * 设计食物评分系统
 * <p>
 * 设计一个支持下述操作的食物评分系统：
 * 修改 系统中列出的某种食物的评分。
 * 返回系统中某一类烹饪方式下评分最高的食物。
 * <p>
 * 实现 FoodRatings 类：
 * FoodRatings(String[] foods, String[] cuisines, int[] ratings) 初始化系统。食物由 foods、cuisines 和 ratings 描述，长度均为 n 。
 * foods[i] 是第 i 种食物的名字。
 * cuisines[i] 是第 i 种食物的烹饪方式。
 * ratings[i] 是第 i 种食物的最初评分。
 * void changeRating(String food, int newRating) 修改名字为 food 的食物的评分。
 * String highestRated(String cuisine) 返回指定烹饪方式 cuisine 下评分最高的食物的名字。如果存在并列，返回 字典序较小 的名字。
 * 注意，字符串 x 的字典序比字符串 y 更小的前提是：x 在字典中出现的位置在 y 之前，也就是说，要么 x 是 y 的前缀，或者在满足 x[i] != y[i] 的第一个位置 i 处，x[i] 在字母表中出现的位置在 y[i] 之前。
 *
 * @author jd95288
 * @date 2025-02-28 0:10
 */
public class FoodRatings2353 {

    static class FoodRatings {

        Map<String, PriorityQueue<String[]>> map;
        Map<String, String> foodMap;
        Map<String, Integer> ratingMap;

        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            int n = foods.length;
            map = new HashMap<>(n);
            foodMap = new HashMap<>(n);
            ratingMap = new HashMap<>(n);
            for (int i = 0; i < n; i++) {
                foodMap.put(foods[i], cuisines[i]);
                ratingMap.put(foods[i], ratings[i]);
                map.putIfAbsent(cuisines[i], new PriorityQueue<>((a, b) -> {
                    int compare = Integer.parseInt(b[0]) - Integer.parseInt(a[0]);
                    if (compare != 0) {
                        return compare;
                    }
                    return a[1].compareTo(b[1]);
                }));
                map.get(cuisines[i]).offer(new String[]{String.valueOf(ratings[i]), foods[i]});
            }
        }

        public void changeRating(String food, int newRating) {
            ratingMap.put(food, newRating);
            map.get(foodMap.get(food)).offer(new String[]{String.valueOf(newRating), food});
        }

        public String highestRated(String cuisine) {
            PriorityQueue<String[]> q = map.get(cuisine);
            while (Integer.parseInt(q.peek()[0]) != ratingMap.get(q.peek()[1])) {
                q.poll();
            }
            return q.peek()[1];
        }
    }

}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */
