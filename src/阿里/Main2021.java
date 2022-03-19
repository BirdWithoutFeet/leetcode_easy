package 阿里;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main2021 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(scanner.nextLine());
            int [] arrayX = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int [] arrayY = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int res = getMaxFromAll(arrayX,arrayY,n);
            System.out.println(res);
        }
    }

    private static int getMaxFromAll(int[] arrayX, int[] arrayY, int n) {
        int [] dp = new int[n+1];
        dp[1] = 1;
        for (int i = 2; i <= n ; i++) {
            if (arrayX[i-2] <= arrayX[i-1] && arrayY[i-2] >= arrayY[i-2] ||
                    arrayX[i-2] >= arrayX[i-1] && arrayY[i-2] <= arrayY[i-2]
            )
                dp[i] = dp[i-1];
            else
                dp[i] = Math.max(dp[i-1]+1,dp[i-1]);
        }
        return dp[n];
    }

}
