package medium;

import java.util.*;

/**
 * 王位继承顺序
 * 一个王国里住着国王、他的孩子们、他的孙子们等等。每一个时间点，这个家庭里有人出生也有人死亡。
 * 这个王国有一个明确规定的王位继承顺序，第一继承人总是国王自己。
 * 我们定义递归函数 Successor(x, curOrder) ，给定一个人 x 和当前的继承顺序，该函数返回 x 的下一继承人。
 * Successor(x, curOrder):
 * 如果 x 没有孩子或者所有 x 的孩子都在 curOrder 中：
 * 如果 x 是国王，那么返回 null
 * 否则，返回 Successor(x 的父亲, curOrder)
 * 否则，返回 x 不在 curOrder 中最年长的孩子
 * 比方说，假设王国由国王，他的孩子 Alice 和 Bob （Alice 比 Bob 年长）和 Alice 的孩子 Jack 组成。
 * <p>
 * 一开始， curOrder 为 ["king"].
 * 调用 Successor(king, curOrder) ，返回 Alice ，所以我们将 Alice 放入 curOrder 中，得到 ["king", "Alice"] 。
 * 调用 Successor(Alice, curOrder) ，返回 Jack ，所以我们将 Jack 放入 curOrder 中，得到 ["king", "Alice", "Jack"] 。
 * 调用 Successor(Jack, curOrder) ，返回 Bob ，所以我们将 Bob 放入 curOrder 中，得到 ["king", "Alice", "Jack", "Bob"] 。
 * 调用 Successor(Bob, curOrder) ，返回 null 。最终得到继承顺序为 ["king", "Alice", "Jack", "Bob"] 。
 * 通过以上的函数，我们总是能得到一个唯一的继承顺序。
 * <p>
 * 请你实现 ThroneInheritance 类：
 * <p>
 * ThroneInheritance(string kingName) 初始化一个 ThroneInheritance 类的对象。国王的名字作为构造函数的参数传入。
 * void birth(string parentName, string childName) 表示 parentName 新拥有了一个名为 childName 的孩子。
 * void death(string name) 表示名为 name 的人死亡。一个人的死亡不会影响 Successor 函数，也不会影响当前的继承顺序。你可以只将这个人标记为死亡状态。
 * string[] getInheritanceOrder() 返回 除去 死亡人员的当前继承顺序列表。
 *
 * @author jd95288
 * @date 2024-04-07 8:42
 */
public class ThroneInheritance1600 {

    private final Map<String, List<String>> children;

    private final Set<String> dead;

    private final String originator;


    public ThroneInheritance1600(String kingName) {
        originator = kingName;
        children = new HashMap<>();
        dead = new HashSet<>();
    }

    public void birth(String parentName, String childName) {
        children.computeIfAbsent(parentName, k -> new ArrayList<>()).add(childName);
    }

    public void death(String name) {
        dead.add(name);
    }

    public List<String> getInheritanceOrder() {
        List<String> curOrder = new ArrayList<>();
        if (!dead.contains(originator)) {
            curOrder.add(originator);
        }
        successor(originator, curOrder);
        return curOrder;
    }

    /**
     * Successor(x, curOrder):
     * 如果 x 没有孩子或者所有 x 的孩子都在 curOrder 中：
     *     如果 x 是国王，那么返回 null，这里的意思是国王的所有孩子均已执行了该函数，也就是遍历完成
     *     否则，返回 Successor(x 的父亲, curOrder)，如果x不是国王，那么是国外的后代，如果其后代都已经在curOrder中就返回parent继续遍历其兄弟
     * 否则，返回 x 不在 curOrder 中最年长的孩子
     */
    public void successor(String name, List<String> curOrder) {
        if (children.get(name) != null && children.get(name).size() != 0) {
            for (String child : children.get(name)) {
                if (!dead.contains(child)) {
                    curOrder.add(child);
                }
                successor(child, curOrder);
            }
        }
    }

    public static void main(String[] args) {
        ThroneInheritance1600 main = new ThroneInheritance1600("king");
        System.out.println(main.getInheritanceOrder());
        main.birth("king", "logan");
        main.birth("logan", "hosea");
        main.birth("king", "leonard");
        main.death("king");
        main.birth("logan", "carl");
        main.death("hosea");
        main.birth("leonard", "ronda");
        main.birth("logan", "betty");
        System.out.println(main.getInheritanceOrder());
    }
}
