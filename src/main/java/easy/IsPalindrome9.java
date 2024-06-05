package easy;

/**
 * @date 2024-06-02 23:30
 */
public class IsPalindrome9 {

    public boolean isPalindrome_v1(int x) {
        if (x < 0) {
            return false;
        }
        int l = String.valueOf(x).length();
        int[] d = new int[l];
        for (int i = l - 1; i >= 0; i--) {
            d[i] = x / (int) Math.pow(10, i);
            x -= d[i] * (int) Math.pow(10, i);
        }
        for (int i = 0; i < d.length; i++) {
            if (d[i] != d[l - 1 - i]) {
                return false;
            }
        }

        return true;
    }
}
