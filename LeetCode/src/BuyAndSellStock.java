public class BuyAndSellStock {

    public static int maxProfit(int[] prices) {
        int inputLen = prices.length;
        int totalProfit = 0;
        for (int i = 1; i < inputLen; i++) {
            int diff = prices[i] - prices[i - 1];
            if (diff > 0) {
                totalProfit += diff;
            }
        }
        return totalProfit;
    }

    public static void main(String[] args) {
        int[] input = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(input));
    }
}
