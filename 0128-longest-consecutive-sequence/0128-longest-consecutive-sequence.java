class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> map=new HashSet<>();
        for(int x:nums)
        {
            map.add(x);
        }
        if(map.size()<=1)
        {
            return map.size();
        }
        int c;
        int res=1;
        for(int val:map)
        {
            int x=val;
            if(!map.contains(x+1))
            {
             int end=x;
            while(map.contains(x-1))
            {
                x=x-1;
            }
             res=Math.max(res,end-x+1);
            }
        }
        return res;
    }
}