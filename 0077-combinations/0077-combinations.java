class Solution {
    public void combinations(List<List<Integer>> arr,ArrayList<Integer> l,int i,int n,int k)
    {
        if(l.size()==k)
        {
            arr.add(new ArrayList(l));
            return ;
        }
        if(i>n)
        {
            return ;
        }
        l.add(i);
        combinations(arr,l,i+1,n,k);

        l.remove(l.size()-1);
        combinations(arr,l,i+1,n,k);
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> arr=new ArrayList<>();
        ArrayList<Integer> l=new ArrayList<>();
        if(k==0)
        {
            return arr;
        }
        combinations(arr,l,1,n,k);
        return arr;
    }
}