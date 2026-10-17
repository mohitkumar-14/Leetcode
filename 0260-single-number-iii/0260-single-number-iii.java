class Solution {
    public int[] singleNumber(int[] nums) {
        if(nums.length<2)
        {
            return nums;
        }
        int ans=0;
        for(int x:nums) 
        {
           ans^=x;
        }

        int bit=ans & (-ans);
        int g1=0,g2=0;
        for(int i=0;i<nums.length;i++)
        {
            if((nums[i]& bit)!=0){
                g1^=nums[i];
            }else{
                g2^=nums[i];
            }
        }
        return new int[]{g1,g2};
    }
}