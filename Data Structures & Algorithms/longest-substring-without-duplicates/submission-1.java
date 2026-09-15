class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null)
            return 0;
        HashSet<Character> set = new HashSet<>();
        char[] word = s.toCharArray();
        int left = 0, right = 0;
        StringBuilder str = new StringBuilder();
        int maxLength = 0;
        while(left<word.length && right<word.length)
        {
            if(!set.contains(word[right]))
            {
                set.add(word[right]);
                str.append(word[right]);
                right++;
                maxLength = Math.max(maxLength, str.length());
            }else
            {
                set.remove(word[left]);
                str.deleteCharAt(0);
                left++;
            }
        }
        return maxLength;
    }
}
