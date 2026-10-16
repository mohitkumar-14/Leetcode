class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        if (n < k){
        return new int[0];
       }
       int ans[]=new int[n-k+1];
       int j=0;
       Deque<Integer> dq=new ArrayDeque<>();
       for(int i=0;i<k;i++)
       {
        while(!dq.isEmpty() && nums[i]>=nums[dq.peekLast()])
        {
            dq.removeLast();
        }
        dq.addLast(i);
       }

       ans[j]=nums[dq.peekFirst()];
       j++;

       for(int i=k;i<n;i++)
       {
        while(!dq.isEmpty() && dq.peekFirst() <= i-k)
        {
          dq.removeFirst();
        }
        while(!dq.isEmpty() && nums[i]>=nums[dq.peekLast()])
        {
            dq.removeLast();
        }
        dq.addLast(i);
        
        ans[j]=nums[dq.peekFirst()];
        j++;
       }
       return ans;
    }
}