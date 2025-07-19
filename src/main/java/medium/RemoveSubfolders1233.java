package medium;

import java.util.*;

/**
 * 删除子文件夹
 * <p>
 * 你是一位系统管理员，手里有一份文件夹列表 folder，你的任务是要删除该列表中的所有 子文件夹，并以 任意顺序 返回剩下的文件夹。
 * 如果文件夹 folder[i] 位于另一个文件夹 folder[j] 下，那么 folder[i] 就是 folder[j] 的 子文件夹 。
 * folder[j] 的子文件夹必须以 folder[j] 开头，后跟一个 "/"。例如，"/a/b" 是 "/a" 的一个子文件夹，但 "/b" 不是 "/a/b/c" 的一个子文件夹。
 * 文件夹的「路径」是由一个或多个按以下格式串联形成的字符串：'/' 后跟一个或者多个小写英文字母。
 * 例如，"/leetcode" 和 "/leetcode/problems" 都是有效的路径，而空字符串和 "/" 不是。
 *
 * @author jd95288
 * @date 2025-07-19 10:57
 */
public class RemoveSubfolders1233 {

    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        String prev = ".";
        List<String> res = new ArrayList<>();
        for (String path : folder) {
            if (path.startsWith(prev)) {
                continue;
            }
            res.add(path);
            prev = path + "/";
        }
        return res;
    }

}
