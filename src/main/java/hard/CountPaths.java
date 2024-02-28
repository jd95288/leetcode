package hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 统计树中的合法路径数目
 * 给你一棵 n 个节点的无向树，节点编号为 1 到 n 。
 * 给你一个整数 n 和一个长度为 n - 1 的二维整数数组 edges ，其中 edges[i] = [ui, vi] 表示节点 ui 和 vi 在树中有一条边。
 * 请你返回树中的 合法路径数目 。
 * 如果在节点 a 到节点 b 之间 恰好有一个 节点的编号是质数，那么我们称路径 (a, b) 是 合法的 。
 * 注意：
 * 路径 (a, b) 指的是一条从节点 a 开始到节点 b 结束的一个节点序列，序列中的节点 互不相同 ，且相邻节点之间在树上有一条边。
 * 路径 (a, b) 和路径 (b, a) 视为 同一条 路径，且只计入答案 一次 。
 *
 * @author jd95288
 * @date 2024-02-27 0:22
 */
public class CountPaths {

    public Map<Integer, Set<Integer>> primeEdges = new HashMap<>();
    public Map<Integer, Set<Integer>> notPrimeEdges = new HashMap<>();
    public Map<Integer, Integer> indirectNodesNumMap = new HashMap<>();
    Set<Integer> counter = new HashSet<>();

    public long countPaths(int n, int[][] edges) {
        for (int i = 0; i < n - 1; i++) {
            int[] edge = edges[i];
            boolean i0 = isPrimeNumber(edge[0]);
            boolean i1 = isPrimeNumber(edge[1]);
            if (i0 && !i1) {
                primeEdges.computeIfAbsent(edge[0], k -> new HashSet<>());
                primeEdges.get(edge[0]).add(edge[1]);
            } else if (!i0 && i1) {
                primeEdges.computeIfAbsent(edge[1], k -> new HashSet<>());
                primeEdges.get(edge[1]).add(edge[0]);
            } else if(!i0){
                notPrimeEdges.computeIfAbsent(edge[0], k -> new HashSet<>());
                notPrimeEdges.computeIfAbsent(edge[1], k -> new HashSet<>());
                notPrimeEdges.get(edge[0]).add(edge[1]);
                notPrimeEdges.get(edge[1]).add(edge[0]);
            }
        }
        long res = 0;
        for (Integer primeNode : primeEdges.keySet()) {
            Set<Integer> nonPrimeNodesOfPrimeEdge = primeEdges.get(primeNode);
            counter.clear();
            int total = 0;
            for (int nonPrimeNode : nonPrimeNodesOfPrimeEdge) {
                counter.add(nonPrimeNode);
                if (indirectNodesNumMap.get(nonPrimeNode) == null) {
                    indirectNodesNumMap.put(nonPrimeNode, 1);
                    countEdges(nonPrimeNode, nonPrimeNode);
                }
                total += indirectNodesNumMap.get(nonPrimeNode);
            }
            total = total + 1;
            res += total * (total - 1L) / 2L;
            for (int nonPrimeNode : nonPrimeNodesOfPrimeEdge) {
                int indirectNodesNum = indirectNodesNumMap.get(nonPrimeNode);
                res -= indirectNodesNum * (indirectNodesNum - 1L) / 2L;
            }
        }
        return res;
    }

    public Set<Integer> countEdges(int key, int nonPrimeNode) {
        if (notPrimeEdges.get(nonPrimeNode) != null) {
            for (Integer node : notPrimeEdges.get(nonPrimeNode)) {
                if (!counter.contains(node)) {
                    indirectNodesNumMap.put(key, indirectNodesNumMap.get(key) + 1);
                    counter.add(node);
                    countEdges(key, node);
                }
            }
        }
        return counter;
    }

    public boolean isPrimeNumber(int num) {
        if (num == 1) {
            return false;
        }
        if (num == 2) {
            return true;
        }
        if (num % 2 == 0) {
            return false;
        }
        for (int i = 3;  i * i <= num; i+=2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
