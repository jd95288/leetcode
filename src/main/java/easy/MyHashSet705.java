package easy;

import java.util.Arrays;
import java.util.BitSet;

/**
 * 设计哈希集合
 *
 * 不使用任何内建的哈希表库设计一个哈希集合（HashSet）。
 * 实现 MyHashSet 类：
 * void add(key) 向哈希集合中插入值 key 。
 * bool contains(key) 返回哈希集合中是否存在这个值 key 。
 * void remove(key) 将给定值 key 从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。
 *
 * @author jd95288
 * @date 2024-04-14 17:40
 */
public class MyHashSet705 {

    public class MyHashSet{

        boolean[] value;

        public MyHashSet() {
            value = new boolean[1000001];
        }

        public void add(int key) {
            value[key] = true;
        }

        public void remove(int key) {
            value[key] = false;
        }

        public boolean contains(int key) {
            return value[key];
        }
    }

}
