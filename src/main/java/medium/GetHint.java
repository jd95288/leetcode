package medium;


/**
 * 猜数字游戏
 * 你在和朋友一起玩 猜数字（Bulls and Cows）游戏，该游戏规则如下：
 * 写出一个秘密数字，并请朋友猜这个数字是多少。朋友每猜测一次，你就会给他一个包含下述信息的提示：
 * 猜测数字中有多少位属于数字和确切位置都猜对了（称为 "Bulls"，公牛），
 * 有多少位属于数字猜对了但是位置不对（称为 "Cows"，奶牛）。也就是说，这次猜测中有多少位非公牛数字可以通过重新排列转换成公牛数字。
 * 给你一个秘密数字 secret 和朋友猜测的数字 guess ，请你返回对朋友这次猜测的提示。
 * 提示的格式为 "xAyB" ，x 是公牛个数， y 是奶牛个数，A 表示公牛，B 表示奶牛。
 * 请注意秘密数字和朋友猜测的数字都可能含有重复数字。
 *
 * @author jd95288
 * @date 2024-03-10 0:36
 */
public class GetHint {

    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        char[] secretCharArray = secret.toCharArray();
        int[] missArray = new int[10];
        int[] cowsArray = new int[10];
        for (int i = 0; i < secretCharArray.length; i++) {
            int guessCharacter = guess.charAt(i) - '0';
            int secretCharacter = secretCharArray[i] - '0';
            if (guessCharacter == secretCharacter) {
                bulls++;
            } else {
                missArray[secretCharacter] += 1;
                cowsArray[guessCharacter] += 1;
            }
        }
        for (int i = 0; i < cowsArray.length; i++) {
            if (missArray[i] > 0 && cowsArray[i] > 0) {
                cows += Math.min(missArray[i], cowsArray[i]);
            }
        }
        return new StringBuilder().append(bulls).append('A').append(cows).append('B').toString();
    }

}
