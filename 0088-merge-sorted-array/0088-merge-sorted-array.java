class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int l=nums1.length;
        if(m==0)
        {
            for(int i=l-1;i>=0 && n>=0;i--)
            {
                nums1[i]=nums2[n-1];
                n--;
            }
        }
        for(int i=l-1;i>=0 && n>0 && m>0;i--)
        {
            if(n>0 && m>0 && nums2[n-1] >= nums1[m-1])
            {
                nums1[i]=nums2[n-1];
                n--;
            }
            else if(n>0 && m>0 && nums1[m-1] > nums2[n-1]){
                nums1[i]=nums1[m-1];
                m--;
            }
        }
        while(m==0 && n>0)
        {
            nums1[n-1]=nums2[n-1];
            n--;
        }
    }
}