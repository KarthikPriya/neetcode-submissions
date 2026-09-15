class Solution {
    public boolean isAnagram(String s, String t) {
        if(s == null && t == null)return true;
        if(s == null && t!=null || s!=null && t==null || s.length() != t.length())return false;

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i=0;i<s.length();i++)
        {
            if(map.containsKey(s.charAt(i)))
            {
                int no = map.get(s.charAt(i));
                no++;
                map.put(s.charAt(i), no);
            }
            else
            {
                map.put(s.charAt(i), 1);
            }
        }

        //iterate the second word
        for(int i=0;i<t.length();i++)
        {
            if(map.containsKey(t.charAt(i)))
            { 
                if(map.get(t.charAt(i)) >1)
                {
                    int no = map.get(t.charAt(i));
                    no--;
                    map.put(t.charAt(i), no);
                }
                else
                    map.remove(t.charAt(i));
            }
            else
            {
                return false;
            }
        }

        if(map.isEmpty())
            return true;
        return false;
    }
}


/*
s="racecar"
t = "carrace"
lets use a dictionary and iterate through the first word, mark the number of letters and their occurences and as a next step iterate through the next word and cross off letters in the dict, if in the end of the second word, dict is empty, its an Anagram
*/