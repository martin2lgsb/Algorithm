/**
 * Created by m2lgsb on 2018/9/25 16:48
 */
public class CalculationSteps {
    public static int[] steps = new int[11];

    public static void main(String[] args) {
        steps[10] = calStep(10);

        for (int i = 0; i < steps.length; i++) {
            System.out.println(steps[i]);
        }
        System.out.println(steps[10]);
    }

    public static int calStep(int n) {
        if (n == 1 || n == 2) {
            return n;
        }

        if (steps[n-1] == 0) {
            steps[n-1] = calStep(n-1);
        }

        if (steps[n-2] == 0) {
            steps[n-2] = calStep(n-2);
        }

        return steps[n-1] + steps[n-2];
    }
}
