package medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 频率跟踪器
 * 请你设计并实现一个能够对其中的值进行跟踪的数据结构，并支持对频率相关查询进行应答。
 * 实现 FrequencyTracker 类：
 * FrequencyTracker()：使用一个空数组初始化 FrequencyTracker 对象。
 * void add(int number)：添加一个 number 到数据结构中。
 * void deleteOne(int number)：从数据结构中删除一个 number 。数据结构 可能不包含 number ，在这种情况下不删除任何内容。
 * bool hasFrequency(int frequency): 如果数据结构中存在出现 frequency 次的数字，则返回 true，否则返回 false。
 *
 * @author jd95288
 * @date 2024-03-21 8:57
 */
public class FrequencyTracker2671 {

    private final Map<Integer, Integer> elements;
    private final Map<Integer, Set<Integer>> fRecord;

    public FrequencyTracker2671() {
        elements = new HashMap<>();
        fRecord = new HashMap<>();
    }

    public void add(int number) {
        Integer f = elements.get(number) == null ? 0 : elements.get(number);
        if (f != 0) {
            fRecord.get(f).remove(number);
        }
        elements.merge(number, 1, Integer::sum);
        fRecord.computeIfAbsent(++f, k -> new HashSet<>());
        fRecord.get(f).add(number);
    }

    public void deleteOne(int number) {
        Integer f = elements.get(number) == null ? 0 : elements.get(number);
        if (f != 0) {
            if (f - 1 == 0) {
                elements.remove(number);
            } else {
                elements.put(number, elements.get(number) - 1);
            }
            fRecord.get(f).remove(number);
            fRecord.computeIfAbsent(--f, k -> new HashSet<>());
            fRecord.get(f).add(number);
        }
    }

    public boolean hasFrequency(int frequency) {
        return fRecord.get(frequency) != null && fRecord.get(frequency).size() > 0;
    }
}
