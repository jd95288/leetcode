package medium;

import java.util.*;

/**
 * O(1) 时间插入、删除和获取随机元素
 * 实现RandomizedSet 类：
 * RandomizedSet() 初始化 RandomizedSet 对象
 * bool insert(int val) 当元素 val 不存在时，向集合中插入该项，并返回 true ；否则，返回 false 。
 * bool remove(int val) 当元素 val 存在时，从集合中移除该项，并返回 true ；否则，返回 false 。
 * int getRandom() 随机返回现有集合中的一项（测试用例保证调用此方法时集合中至少存在一个元素）。每个元素应该有 相同的概率 被返回。
 * 你必须实现类的所有函数，并满足每个函数的 平均 时间复杂度为 O(1) 。
 *
 * @author jd95288
 * @date 2024-03-14 16:07
 */
public class RandomizedSet380 {

    Map<Integer, Integer> map;
    List<Integer> list;
    Random r = new Random();

    public RandomizedSet380() {
        this.map = new HashMap<>();
        this.list = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (map.get(val) != null) {
            return false;
        }
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (map.get(val) == null) {
            return false;
        }
        int index = map.get(val);
        int last = list.get(list.size() - 1);
        list.set(index, last);
        list.remove(list.size() - 1);
        map.put(last, index);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        return list.get(r.nextInt(list.size()));
    }

    public static void main(String[] args) {
        RandomizedSet380 main = new RandomizedSet380();
//        System.out.println(main.insert(1));
//        System.out.println(main.remove(2));
//        System.out.println(main.insert(2));
//        System.out.println(main.getRandom());
//        System.out.println(main.remove(1));
//        System.out.println(main.insert(2));
//        System.out.println(main.getRandom());

//        System.out.println(main.insert(0));
//        System.out.println(main.insert(1));
//        System.out.println(main.remove(0));
//        System.out.println(main.insert(2));
//        System.out.println(main.remove(1));
//        System.out.println(main.getRandom());


//        System.out.println(main.remove(0));
//        System.out.println(main.remove(0));
//        System.out.println(main.insert(0));
//        System.out.println(main.getRandom());
//        System.out.println(main.remove(0));
//        System.out.println(main.insert(0));
        System.out.println(main.insert(1));
        System.out.println(main.insert(10));
        System.out.println(main.insert(20));
        System.out.println(main.insert(30));
        for (int i = 0; i < 100; i++) {
            System.out.println(main.getRandom());
        }
    }
}
