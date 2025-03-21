package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 设计有序流
 * <p>
 * 有 n 个 (id, value) 对，其中 id 是 1 到 n 之间的一个整数，value 是一个字符串。不存在 id 相同的两个 (id, value) 对。
 * 设计一个流，以 任意 顺序获取 n 个 (id, value) 对，并在多次调用时 按 id 递增的顺序 返回一些值。
 * 实现 OrderedStream 类：
 * - OrderedStream(int n) 构造一个能接收 n 个值的流，并将当前指针 ptr 设为 1 。
 * - String[] insert(int id, String value) 向流中存储新的 (id, value) 对。存储后：
 * - 如果流存储有 id = ptr 的 (id, value) 对，则找出从 id = ptr 开始的 最长 id 连续递增序列 ，并 按顺序 返回与这些 id 关联的值的列表。然后，将 ptr 更新为最后那个  id + 1 。
 * - 否则，返回一个空列表。
 *
 * @author jd95288
 * @date 2025-02-24 8:50
 */
public class OrderedStream1656 {

    static class OrderedStream {

        private final String[] buffer;

        private int pos = 1;

        public OrderedStream(int n) {
            buffer = new String[n + 1];
        }

        public List<String> insert(int idKey, String value) {
            List<String> res = new ArrayList<>();
            if (idKey != pos) {
                buffer[idKey] = value;
                return res;
            }
            buffer[pos] = value;
            while (pos < buffer.length && buffer[pos] != null) {
                res.add(buffer[pos++]);
            }
            return res;
        }
    }


}


/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(idKey,value);
 */
