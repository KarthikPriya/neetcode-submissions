class Solution {
    public boolean isAnagram(String s, String t) {
        if((s != null && t == null) || (s == null && t!= null) || (s.length() != t.length()))
            return false;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i=0;i<s.length();i++)
        {
            if(map.containsKey(s.charAt(i)))
            {
                int num = map.get(s.charAt(i));
                map.put(s.charAt(i), ++num);
            }else
            {
                map.put(s.charAt(i), 1);
            }
        }
        //iterate t and check each element while removing the occurence
        /*
        b - 2
        c - 2
        */
        //System.out.println(map);
        for(int i=0;i<t.length();i++)
        {
            if(!map.containsKey(t.charAt(i)))
                return false;
            int diff = map.get(t.charAt(i));
            diff--;
            
            map.put(t.charAt(i), diff);
            if(diff == 0)
                map.remove(t.charAt(i));
        }
        if(map.isEmpty())
            return true;
        return true;
    }
}

