class Solution {
    public int characterReplacement(String s, int k) {
        if(s == null)
            return 0;
        //character frequency
        HashMap<Character, Integer> frequencyMap = new HashMap<>();
        int maxCount = 0;
        int maxLength = 0;
        int windowLength = 0;
        int left = 0;
        for(int right = 0;right<s.length();right++)
        {
            char rightChar = s.charAt(right);
            frequencyMap.put(rightChar, frequencyMap.getOrDefault(rightChar, 0) + 1);
            maxCount = Math.max(maxCount, frequencyMap.get(rightChar));
            windowLength = right - left +1;
            if(windowLength - maxCount > k)
            {
                char leftChar = s.charAt(left);
                frequencyMap.put(leftChar, frequencyMap.get(leftChar)-1);
                left++;
            }
            maxLength = Math.max(maxLength, right-left+1);
        }
        return maxLength;
    }
}


