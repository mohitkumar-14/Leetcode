class Solution {
    public int GreaterElement(int val,int nums[]){
        Deque<Integer> stack= new ArrayDeque<>();
        int ans=-1;
        for(int i=nums.length-1;i>=0;i--)
        {
            while(!stack.isEmpty() && val >= stack.peek())
            {
                stack.pop();
            }
            if(nums[i] == val) 
            {
             if(!stack.isEmpty()) 
             {
                ans = stack.peek();
             }
            break;
          }
        stack.push(nums[i]);
        }
        return ans;
    }
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n1=nums1.length;
        int ans[]=new int[n1];
        for(int i=0;i<n1;i++)
        {
          ans[i]=GreaterElement(nums1[i],nums2);  
        }
        return ans;
    }
}