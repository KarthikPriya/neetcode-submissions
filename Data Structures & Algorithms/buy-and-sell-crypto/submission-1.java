class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null)
            return 0;
        int minValue = Integer.MAX_VALUE;
        int maxProfit = Integer.MIN_VALUE;
        for(int i=0;i<prices.length;i++)
        {
            if(prices[i] < minValue)
                minValue = Math.min(minValue, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i]-minValue);
        }
        return maxProfit;
    }
}

/*
prices = [10,1,5,6,7,1]
minValue = 1;
maxProfit = 6


*/