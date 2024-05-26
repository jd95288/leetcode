package easy;

/**
 * 二进制求和
 * <p>
 * 给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。
 *
 * @author jd95288
 * @date 2024-05-25 21:50
 */
public class AddBinary67 {

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int tmp = 0;
        int ai = a.length() - 1;
        int bi = b.length() - 1;
        while (ai >= 0 || bi >= 0) {
            // 使用判断是1ms
            int ac = ai >= 0 ? a.charAt(ai) - '0' : 0;
            int bc = bi >= 0 ? b.charAt(bi) - '0' : 0;
            int res = tmp + ac + bc;
            if (res > 1) {
                // 出错点：这里不能写成0
                sb.append(res % 2);
                tmp = 1;
            } else {
                sb.append(res);
                tmp = 0;
            }
            ai--;
            bi--;
        }
        if (tmp > 0) {
            sb.append(tmp);
        }
        return sb.reverse().toString();
    }
}
