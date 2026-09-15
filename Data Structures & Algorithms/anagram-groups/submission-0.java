class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0)
            return new ArrayList<List<String>>();
        //map that contains the result key and values
        HashMap<String, List<String>> resultMap = new HashMap<>();
        for(int i=0;i<strs.length;i++)
        {
            //call fun to get which bucket to put that string into
            String newWord = alphaOrder(strs[i]);
            if(resultMap.containsKey(newWord))
            {
                List<String> temp = resultMap.get(newWord);
                temp.add(strs[i]);
                resultMap.put(newWord,temp);
            }
            else {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                resultMap.put(newWord, list);
            }
        }
        return new ArrayList<>(resultMap.values());
    }
    //function to traverse using ASCII
    public String alphaOrder(String word)
    {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<word.length();i++)
        {
            char c = word.charAt(i);
            if(map.containsKey(c))
            {
                int num = map.get(c);
                num++;
                map.put(c, num);
            }
else
                map.put(c, 1);
        }
        //traverse using ASCII and form the new word
        StringBuilder temp = new StringBuilder();
        for (int i = 97; i <= 122; i++) 
        {

            if(map.containsKey((char)i))
            {
                int num = map.get((char)i);
                for(int j = 1;j<=num;j++)
                    temp.append((char)i);
                    num--;
                }
            }
        return temp.toString();
    }
}
