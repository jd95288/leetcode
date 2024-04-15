package easy;

import java.util.Arrays;

/**
 * 设计哈希映射
 * 不使用任何内建的哈希表库设计一个哈希映射（HashMap）。
 *
 * 实现 MyHashMap 类：
 * MyHashMap() 用空映射初始化对象
 * void put(int key, int value) 向 HashMap 插入一个键值对 (key, value) 。如果 key 已经存在于映射中，则更新其对应的值 value 。
 * int get(int key) 返回特定的 key 所映射的 value ；如果映射中不包含 key 的映射，返回 -1 。
 * void remove(key) 如果映射中存在 key 的映射，则移除 key 和它所对应的 value 。
 *
 * @author jd95288
 * @date 2024-04-15 0:15
 */
public class MyHashMap706 {
    public class MyHashMap{
        int[] values;
        public MyHashMap() {
            values = new int[1000001];
            Arrays.fill(values, -1);
        }

        public void put(int key, int value) {
            values[key] = value;
        }

        public int get(int key) {
            return values[key];
        }

        public void remove(int key) {
            values[key] = -1;
        }
    }

}
