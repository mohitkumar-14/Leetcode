class Solution {
    public boolean checkPal(char arr[],int i,int j,boolean delete)
    {
        if(i>j)
        {
            return true;
        }
        if(arr[i]!=arr[j])
        {
            if(delete==false)
            {
                delete=true;
                return checkPal(arr,i+1,j,delete) || checkPal(arr,i,j-1,delete);
            }
            return false;
        }
        
        return checkPal(arr,i+1,j-1,delete);
    }
    public boolean validPalindrome(String s) {
        char []arr=s.toCharArray();
        int n=arr.length;
        boolean delete=false;
        return checkPal(arr,0,n-1,delete);
    }
}