class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int count=0;
        int n=people.length;

        Arrays.sort(people);
        int i=0;
        int j=n-1;
        while(i<=j)
        {
            int weight=people[i]+people[j];
            if(weight > limit)
            {
                count++;
                j--;
            }
            else{
                count++;
                i++;
                j--;
            }
        }
        return count;
    }
}