class Solution {
    public boolean isPalindrome(String s) {
        if(s == null)   
            return true;
        StringBuilder newStr = new StringBuilder();
        for(char c : s.toCharArray())
        {
            if(Character.isLetterOrDigit(c))
            {
                newStr.append(Character.toLowerCase(c));
            }
        }
        return (newStr.toString().equals(newStr.reverse().toString()));
    }
}
