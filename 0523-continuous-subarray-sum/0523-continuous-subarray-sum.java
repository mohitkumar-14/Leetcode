class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n=nums.length;
        int sum=0;
        for(int x:nums)
        {
            sum+=x;
        }
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        int prefix_sum=0;
        for(int i=0;i<n;i++)
        {
            prefix_sum+=nums[i];
            int mod=prefix_sum % k;
            if(map.containsKey(mod))
            {
                if((i-map.get(mod)+1)>2)
                {
                    return true;
                }
            }
            else{
                map.put(mod,i);
            }
        }
        return false;
    }
}