class Solution {
    public boolean isAnagram(String s, String t) {
        if(s == null && t == null)
            return true;
        if(s.length() != t.length() || s== null && t != null || s!= null && t == null)
            return false;
        HashMap<Character,Integer> map = new HashMap<>();
        //add characters and their occurences to map
        for(int i=0;i<s.length();i++)
        {
            if(map.containsKey(s.charAt(i)))
            {
                int num = map.get(s.charAt(i));
                map.put(s.charAt(i), num+1);
            }
            else
                map.put(s.charAt(i),0);
        }
        //go through t and check if its anagram
        for(int i=0;i<t.length();i++)
        {
            if(map.containsKey(t.charAt(i)))
            {
                if(map.get(t.charAt(i)) != 0)
                {
                    int num = map.get(t.charAt(i));
                    map.put(t.charAt(i),num-1);
                }else
                    map.remove(t.charAt(i));
            }  
        }
        return map.isEmpty();
    }
}
