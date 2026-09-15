class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null)
            return 0;
        
        int minPrice = prices[0], maxProfit = 0;

        for(int price : prices)
        {
            minPrice = Math.min(minPrice, price);
            
            maxProfit = Math.max(price - minPrice, maxProfit);
        }
        return maxProfit;
    }
}
