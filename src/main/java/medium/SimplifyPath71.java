package medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 简化路径
 * 给你一个字符串 path ，表示指向某一文件或目录的 Unix 风格 绝对路径 （以 '/' 开头），请你将其转化为 更加简洁的规范路径。
 * <p>
 * 在 Unix 风格的文件系统中规则如下：
 * 一个点 '.' 表示当前目录本身。
 * 此外，两个点 '..' 表示将目录切换到上一级（指向父目录）。
 * 任意多个连续的斜杠（即，'//' 或 '///'）都被视为单个斜杠 '/'。
 * 任何其他格式的点（例如，'...' 或 '....'）均被视为有效的文件/目录名称。
 * <p>
 * 返回的 简化路径 必须遵循下述格式：
 * 始终以斜杠 '/' 开头。
 * 两个目录名之间必须只有一个斜杠 '/' 。
 * 最后一个目录名（如果存在）不能 以 '/' 结尾。
 * 此外，路径仅包含从根目录到目标文件或目录的路径上的目录（即，不含 '.' 或 '..'）。
 * <p>
 * 返回简化后得到的 规范路径 。
 *
 * @author jd95288
 * @date 2024-09-14 9:39
 */
public class SimplifyPath71 {

    public String simplifyPath(String path) {
        path = path.replaceAll("/+", "/");
        String[] dir = path.split("/");
        Deque<String> stack = new ArrayDeque<>();
        for (int i = 1; i < dir.length; i++) {
            stack.push(dir[i]);
        }
        StringBuilder sb = new StringBuilder();
        List<String> p = new ArrayList<>();
        Deque<String> ignore = new ArrayDeque<>();
        while (!stack.isEmpty()) {
            String dirName = stack.pop();
            if ("..".equals(dirName)) {
                ignore.push("..");
            } else if (!".".equals(dirName)) {
                if (!ignore.isEmpty()) {
                    ignore.pop();
                    continue;
                }
                p.add(dirName);
            }
        }
        sb.append("/");
        for (int i = p.size() - 1; i >= 0; i--) {
            sb.append(p.get(i)).append("/");
        }
        if (sb.length() > 1) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
}
