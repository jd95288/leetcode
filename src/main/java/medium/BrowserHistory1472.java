package medium;

/**
 * 设计浏览器历史记录
 * <p>
 * 你有一个只支持单个标签页的 浏览器 ，最开始你浏览的网页是 homepage ，你可以访问其他的网站 url ，也可以在浏览历史中后退 steps 步或前进 steps 步。
 * 请你实现 BrowserHistory 类：
 * BrowserHistory(string homepage) ，用 homepage 初始化浏览器类。
 * void visit(string url) 从当前页跳转访问 url 对应的页面  。执行此操作会把浏览历史前进的记录全部删除。
 * string back(int steps) 在浏览历史中后退 steps 步。如果你只能在浏览历史中后退至多 x 步且 steps > x ，那么你只后退 x 步。请返回后退 至多 steps 步以后的 url 。
 * string forward(int steps) 在浏览历史中前进 steps 步。如果你只能在浏览历史中前进至多 x 步且 steps > x ，那么你只前进 x 步。请返回前进 至多 steps步以后的 url 。
 *
 * @author jd95288
 * @date 2025-02-26 8:48
 */
public class BrowserHistory1472 {

    class BrowserHistory {

        String[] history = new String[5000];
        int tail = 0;
        int cur = 0;

        public BrowserHistory(String homepage) {
            history[0] = homepage;
        }

        public void visit(String url) {
            history[++cur] = url;
            tail = cur;
        }

        public String back(int steps) {
            cur = Math.max(0, cur - steps);
            return history[cur];
        }

        public String forward(int steps) {
            cur = Math.min(tail, cur + steps);
            return history[cur];
        }
    }

}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
