package medium;

import java.util.*;

/**
 * @author jd95288
 * @date 2024-02-23 16:06
 */
public class KthLargestLevelSum {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    public static void main(String[] args) {
        KthLargestLevelSum main = new KthLargestLevelSum();
        long res = main.kthLargestLevelSumBetter(new TreeNode(1, new TreeNode(2), new TreeNode(3)), 2);
        System.out.println(res);
    }

    // 使用递归的话就是占用空间大，需要保存栈信息，这个算是深度优先遍历，先序遍历；25ms,76.18M
    // 广度优先需要使用队列，将子树根节点放入队列，消费队列求和，再将子树根节点放入队列，记录laccBetter；这个是官方解答，不过需要45ms（击败了14.52），空间55.77M（击败了100%）
    // 最快的应该是BFS（广度优先搜索）+排序/快速选择
    // 什么是快速选择？快速选择的思想是省略了一些无用的排序操作，直接将问题转换为n-k位置的数组分隔，左侧小于，右侧大于。
    public long[] laccBetter = new long[100000];
    public int maxlevel = 0;
    public long kthLargestLevelSumBetter(TreeNode root, int k) {
        traverseSubTreeUpdateBetter(root, 0);
        if (k > maxlevel + 1) {
            return -1;
        }
        //O(n log(n))
        Arrays.sort(laccBetter);
        return laccBetter[100000-k];
    }
    public void traverseSubTreeUpdateBetter(TreeNode subTree, int level) {
        //可以不记录这个值，排序后使用lacc[100000-k] == 0来返回，但是效果不明显，没有提升1ms
        maxlevel = Math.max(maxlevel, level);
        laccBetter[level] += subTree.val;
        if (subTree.left != null) {
            traverseSubTreeUpdateBetter(subTree.left, level + 1);
        }
        if (subTree.right != null) {
            traverseSubTreeUpdateBetter(subTree.right, level + 1);
        }
    }

    /**
     * 反向优化了…… ArrayList排序，小列表是插入排序O(n^2)，大列表是归并排序TimSort O(n log(n))
     * 41ms 80.64M
     */
    public ArrayList<Long> accList = new ArrayList<>();
    @Deprecated
    public long getKthLargestLevelSumUpdate1(TreeNode root, int k) {
        traverseSubTreeUpdate1(root, 0);
        if (k > maxlevel + 1) {
            return -1;
        }
        // 其实这里直接排maxlevel即可。
        accList.sort(Comparator.reverseOrder());
        return accList.get(k-1);
    }

    @Deprecated
    public void traverseSubTreeUpdate1(TreeNode subTree, int level) {
        maxlevel = Math.max(maxlevel, level);
        // 这里的判断条件不能写accList.get(level),因为没有初始化，数组越界
        if (accList.size() == level) {
            accList.add(level, (long) subTree.val);
        } else {
            accList.set(level, accList.get(level) + subTree.val);
        }
        if (subTree.left != null) {
            traverseSubTreeUpdate1(subTree.left, level + 1);
        }
        if (subTree.right != null) {
            traverseSubTreeUpdate1(subTree.right, level + 1);
        }
    }

    /**
     * -----------------------------------------------------------------------------------
     * 这个虽然能通过但是效率太低，填充浪费了时间，没必要为了使用降序排序的Comparator使用包装类
     * 不过也没多大差别吧，会自动装箱拆箱
     * 73ms,81.04M
     */
    public Long[] lacc = new Long[100000];
    public long getKthLargestLevelSumUpdate(TreeNode root, int k) {
        // 这个完全没必要
        Arrays.fill(lacc, 0L);
        traverseSubTreeUpdate(root, 0);
        if (k > maxlevel + 1) {
            return -1;
        }
        Arrays.sort(lacc, Comparator.reverseOrder());
        return lacc[k-1];
    }

    public void traverseSubTreeUpdate(TreeNode subTree, int level) {
        maxlevel = Math.max(maxlevel, level);
        lacc[level] += subTree.val;
        if (subTree.left != null) {
            traverseSubTreeUpdate(subTree.left, level + 1);
        }
        if (subTree.right != null) {
            traverseSubTreeUpdate(subTree.right, level + 1);
        }
    }

    /**-------------------------------------------------------------*/

    /**
     * 不能用set，重复的值被过滤掉影响结果  52ms,84.48M
     */
    public Map<Integer, Long> levelAccumulator = new HashMap<>();
    @Deprecated
    public long getKthLargestLevelSum(TreeNode root, int k) {
        traverseSubTree(root, 0);
        if (k > levelAccumulator.keySet().size()) {
            return -1;
        }
        // 不能用set，重复的值被过滤掉影响顺序
//        TreeSet<Long> sortedSet = new TreeSet<>(levelAccumulator.values());
//        Iterator<Long> iterator = sortedSet.descendingIterator();
//        long i = 0;
//        long res = 0;
//        while (iterator.hasNext()){
//            i++;
//            res = iterator.next();
//            if(i == k){
//                break;
//            }
//        }
        ArrayList<Long> acc = new ArrayList<>(levelAccumulator.values());
        Collections.sort(acc);
        return acc.get(acc.size()-k);
    }

    @Deprecated
    public void traverseSubTree(TreeNode subTree, int level) {
        if (levelAccumulator.get(level) == null) {
            levelAccumulator.put(level, (long) subTree.val);
        } else {
            levelAccumulator.put(level, levelAccumulator.get(level) + subTree.val);
        }
        if (subTree.left != null) {
            traverseSubTree(subTree.left, level + 1);
        }
        if (subTree.right != null) {
            traverseSubTree(subTree.right, level + 1);
        }
    }

    public int[] treeVals = new int[100000];
    /**
     * 直接递归遍历的时候就可以求和，无需转为数组再求和
     */
    @Deprecated
    public void traverseSubTree(TreeNode subTree, int index, int level) {
        treeVals[index] = subTree.val;
        if (levelAccumulator.get(level) == null) {
            levelAccumulator.put(level, (long) subTree.val);
        } else {
            levelAccumulator.put(level, levelAccumulator.get(level) + subTree.val);
        }
        if (subTree.left != null) {
            traverseSubTree(subTree.left, 2 * index + 1, level + 1);
        }
        if (subTree.right != null) {
            traverseSubTree(subTree.right, 2 * index + 2, level + 1);
        }
    }
}
