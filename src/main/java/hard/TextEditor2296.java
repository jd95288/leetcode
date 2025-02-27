package hard;


/**
 * 设计一个文本编辑器
 * <p>
 * 请你设计一个带光标的文本编辑器，它可以实现以下功能：
 * 添加：在光标所在处添加文本。
 * 删除：在光标所在处删除文本（模拟键盘的删除键）。
 * 移动：将光标往左或者往右移动。
 * 当删除文本时，只有光标左边的字符会被删除。光标会留在文本内，也就是说任意时候 0 <= cursor.position <= currentText.length 都成立。
 * <p>
 * 请你实现 TextEditor 类：
 * TextEditor() 用空文本初始化对象。
 * void addText(string text) 将 text 添加到光标所在位置。添加完后光标在 text 的右边。
 * int deleteText(int k) 删除光标左边 k 个字符。返回实际删除的字符数目。
 * string cursorLeft(int k) 将光标向左移动 k 次。返回移动后光标左边 min(10, len) 个字符，其中 len 是光标左边的字符数目。
 * string cursorRight(int k) 将光标向右移动 k 次。返回移动后光标左边 min(10, len) 个字符，其中 len 是光标左边的字符数目。
 *
 * @author jd95288
 * @date 2025-02-27 8:41
 */
public class TextEditor2296 {

    class TextEditor {

        StringBuilder prefix;
        StringBuilder suffix;

        public TextEditor() {
            prefix = new StringBuilder();
            suffix = new StringBuilder();
        }

        public void addText(String text) {
            prefix.append(text);
        }

        public int deleteText(int k) {
            int remainder = Math.max(0, prefix.length() - k);
            int cnt = prefix.length() - remainder;
            prefix.setLength(remainder);
            return cnt;
        }

        public String cursorLeft(int k) {
            while (k > 0 && prefix.length() > 0) {
                suffix.append(prefix.charAt(prefix.length() - 1));
                prefix.setLength(prefix.length() - 1);
                k--;
            }
            return prefix.substring(Math.max(prefix.length() - 10, 0));
        }

        public String cursorRight(int k) {
            while (k > 0 && suffix.length() > 0) {
                prefix.append(suffix.charAt(suffix.length() - 1));
                suffix.setLength(suffix.length() - 1);
                k--;
            }
            return prefix.substring(Math.max(prefix.length() - 10, 0));
        }
    }

}


/**
 * Your TextEditor object will be instantiated and called as such:
 * TextEditor obj = new TextEditor();
 * obj.addText(text);
 * int param_2 = obj.deleteText(k);
 * String param_3 = obj.cursorLeft(k);
 * String param_4 = obj.cursorRight(k);
 */
