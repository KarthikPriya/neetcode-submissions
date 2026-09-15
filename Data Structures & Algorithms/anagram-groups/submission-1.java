class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null)
            return new ArrayList<List<String>>();

        HashMap<String, List<String>> map = new HashMap<>();
        for(String s : strs)
        {
            char[] charStr = s.toCharArray();
            Arrays.sort(charStr);
            String newlyBuiltStr = new String(charStr);
            if(map.containsKey(newlyBuiltStr))
            {
                List<String> sublist = map.get(newlyBuiltStr);
                sublist.add(s);
                map.put(newlyBuiltStr, sublist);
            }
            else {
                List<String> newList = new ArrayList<String>();
                newList.add(s);
                map.put(newlyBuiltStr, newList);
            }
        }
        return new ArrayList<>(map.values());
    }
}



/*
act, cat

pots, tops, stop

hat
*/