class Solution {
    public void nextPermutation(int[] nums) {
        // boolean reverse=true;
        // for(int i=nums.length-2;i>=0;i--)
        // {
        //    if(nums[i]<nums[i+1])
        //    {
        //       reverse=false;
        //       int max=-1;
        //       for(int j=i+1;j<nums.length;j++)
        //       {
        //          if(nums[j]>nums[i] && (max==-1 || nums[j]<nums[max]))
        //          {
        //             max=j;
        //          }
        //       }
        //       int t=nums[i];
        //       nums[i]=nums[max];
        //       nums[max]=t;

        //       int start=i+1;
        //       int end=nums.length-1;
        //       while(start<end)
        //       {
        //         int temp=nums[start];
        //         nums[start]=nums[end];
        //         nums[end]=temp;
        //         start++;
        //         end--;
        //       }
        //       break;
        //    }
        // }
        // if(reverse==true)
        // {
        //     int st=0,ed=nums.length-1;
        //     while(st<ed)
        //     {
        //         int t=nums[st];
        //         nums[st]=nums[ed];
        //         nums[ed]=t;
        //         st++;
        //         ed--;
        //     }
        // }
        int ind=-1;
        for(int i=nums.length-2;i>=0;i--)
        {
            if(nums[i]<nums[i+1])
            {
                ind=i;
                break;
            }
        }
        if(ind ==-1)
        {
            int st=0,ed=nums.length-1;
            while(st<ed)
            {
                int t=nums[st];
                nums[st]=nums[ed];
                nums[ed]=t;
                st++;
                ed--;
            }
            return ;
        }
        for(int i=nums.length-1;i>ind;i--)
        {
            if(nums[i]>nums[ind])
            {
              int t=nums[i];
              nums[i]=nums[ind];
              nums[ind]=t;
              break;
            }
        }
        int st=ind+1,ed=nums.length-1;
        while(st<ed)
        {
                int t=nums[st];
                nums[st]=nums[ed];
                nums[ed]=t;
                st++;
                ed--;
        }
    }
}