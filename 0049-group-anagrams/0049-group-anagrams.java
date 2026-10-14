class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
     HashMap<String,List<String>> map=new HashMap<>();
     for(String s: strs)
     {
        int freq[]=new int[26];
        for(char ch:s.toCharArray())
        {
            freq[ch-'a']++;
        }

        StringBuilder key =new StringBuilder();
        for(int count: freq)
        {
            key.append(count);
            key.append('#');
        }
        if(!map.containsKey(key.toString()))
        {
            map.put(key.toString(),new ArrayList<>());
        }
        map.get(key.toString()).add(s);
     }
     return new ArrayList<>(map.values());
    }
}