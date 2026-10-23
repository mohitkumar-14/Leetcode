class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans=new ArrayList<>();
        int floor=nums.length/3;

        if(nums.length==1)
        {
            ans.add(nums[0]);
            return ans;
        }

        int c1=0,c2=0;
        int ans1=Integer.MIN_VALUE,ans2=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++)
        {
           if(c1==0 && nums[i]!=ans2)
           {
            ans1=nums[i];
            c1++;
           }
           else if(c2==0 && nums[i]!=ans1)
           {
            ans2=nums[i];
            c2++;
           }
           else if(ans1!=nums[i] && ans2==nums[i])
           {
              c2++;
           }
           else if(ans1==nums[i] && ans2!=nums[i])
           {
              c1++;
           }
           else 
           {
              c1--;
              c2--;
           }
        }
        int ans1Freq=0,ans2Freq=0;
        for(int x:nums)
        {
            if(x==ans1)
            {
                ans1Freq++;
            }
            else if(x==ans2)
            {
                ans2Freq++;
            }
        }
        
        if(ans1Freq > floor)
        {
            ans.add(ans1);
        }
        if(ans2Freq > floor)
        {
            ans.add(ans2);
        }
        return ans;
    }
}