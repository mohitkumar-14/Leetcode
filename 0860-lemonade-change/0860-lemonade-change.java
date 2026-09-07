class Solution {
    public boolean lemonadeChange(int[] bills) {
        // Arrays.sort(bills);
        int ten=0;
        int five=0;
        for(int i=0;i<bills.length;i++)
        {
            if(bills[i]==5)
            {
                five++;
            }
            else if(bills[i]==10)
            {
                if(five==0)
                {
                    return false;
                }
                five--;
                ten++;
            }
            else if(bills[i]==20)
            {
                if(ten>0)
                {
                  ten--;
                  if(five==0)
                  {
                     return false;
                   }
                  five--;
                }
                else{
                    if(five<3)
                    {
                        return false;
                    }
                    five=five-3;
                }
            }
        }
        return true;
    }
}