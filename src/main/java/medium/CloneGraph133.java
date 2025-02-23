package medium;

import utils.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 克隆图
 * <p>
 * 给你无向 连通 图中一个节点的引用，请你返回该图的 深拷贝（克隆）。
 * 图中的每个节点都包含它的值 val（int） 和其邻居的列表（list[Node]）。
 * <p>
 * class Node {
 * public int val;
 * public List<Node> neighbors;
 * }
 * <p>
 * 测试用例格式：
 * 简单起见，每个节点的值都和它的索引相同。例如，第一个节点值为 1（val = 1），第二个节点值为 2（val = 2），以此类推。该图在测试用例中使用邻接列表表示。
 * 邻接列表 是用于表示有限图的无序列表的集合。每个列表都描述了图中节点的邻居集。
 * 给定节点将始终是图中的第一个节点（值为 1）。你必须将 给定节点的拷贝 作为对克隆图的引用返回。
 *
 * @author jd95288
 * @date 2025-02-23 16:56
 */
public class CloneGraph133 {

    Map<Integer, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Node cloneNode = map.get(node.val);
        if (cloneNode != null) {
            return cloneNode;
        }
        cloneNode = new Node(node.val);
        map.put(node.val, cloneNode);
        List<Node> cloneNeighbors = new ArrayList<>(node.neighbors.size());
        for (Node neighbor : node.neighbors) {
            Node cloneNeighbor = cloneGraph(neighbor);
            cloneNeighbors.add(cloneNeighbor);
        }
        cloneNode.neighbors = cloneNeighbors;
        return cloneNode;
    }
}
