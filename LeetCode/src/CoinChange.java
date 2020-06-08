import java.util.Arrays;

public class CoinChange {

    /**
     * The brute force solution is recursive. If the target amount is zero, then we need zero coins.
     * Otherwise, we use each coin and ask the helper function to get minimum number of coins for the
     * new amount(current amount - coin value)
     * Time-complexity: O(amount ^ n), exponential
     */
    public static int coinChangeBF(int[] coins, int amount) {
        if(amount == 0) {
            return 0;
        }
        int result = Integer.MAX_VALUE;
        for(int coin : coins) {
            if(coin <= amount) {
                result = Math.min(result, coinChangeBF(coins, amount - coin)) + 1;
            }
        }
        return result;
    }

    /**
     * Top-down with memoization by caching results. Using the similar approach as brute force
     * but caching the results of the sub-problems to enable optimization.
     * Time-complexity: O(amount * n)
     */
    public static int coinChangeTD(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        return coinChangeTDHelper(coins, amount, memo);
    }

    private static int coinChangeTDHelper(int[] coins, int amount, int[] memo) {
        if(amount == 0) {
            return 0;
        }
        if(memo[amount] != -1) {
            return memo[amount];
        }
        int result = Integer.MAX_VALUE;
        for(int coin : coins) {
            if(coin <= amount) {
                result = Math.min(result, coinChangeTDHelper(coins, amount - coin, memo) + 1);
            }
        }
        memo[amount] = result;
        return result;
    }

    /**
     * Dynamic Programming, bottom-up solution. Calculate sub-problems first and use them for larger tasks
     * Basically, fill memoization table from left to right, and the solution is the last element.
     * Time-complexity: O(amount * n)
     */
    public static int coinChangeDP(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1; i <= amount; i++) {
            for(int coin : coins) {
                if(coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;

        System.out.println("Brute force Minimum coins: " + coinChangeBF(coins, amount));
        System.out.println("Memoization Minimum coins: " + coinChangeTD(coins, amount));
        System.out.println("Dynamic Programming Minimum coins: " + coinChangeDP(coins, amount));
    }
}
