package common;

/**
 * Created by m2lgsb on 2018/9/25 19:16
 */
public class CoinChange {
    public static void main(String[] args) {
        int[] values = {1, 2, 5, 10, 20, 50, 100};
        int[] counts = {3, 1, 2, 1, 1, 3, 5};
        int[] num = change(442, values, counts);
        print(num, values);
    }

    public static int[] change(int money, int[] values, int[] counts) {
        int[] result = new int[values.length];
        for (int i = values.length - 1; i >= 0; i--) {
            int num = 0;
            int c = min(money / values[i], counts[i]);
            money = money - c * values[i];
            num += c;
            result[i] = num;
        }

        return result;
    }

    static int min(int i, int j) {
        return i < j ? i : j;
    }

    static void print(int[] num, int[] values) {
        for (int i = 0; i < values.length; i++) {
            if (num[i] != 0) {
                System.out.println("需要面额为" + values[i] + "的人民币" + num[i] + "张");
            }
        }
    }
}
