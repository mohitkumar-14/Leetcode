class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
       int car[][]=new int[position.length][2];
       for(int i=0;i<position.length;i++)
       {
        car[i][0]=position[i];
        car[i][1]=speed[i];
       }

       Arrays.sort(car,(a,b)->b[0]-a[0]);

       int fleet=0;
       double prevTime=0;
       for(int i=0;i<position.length;i++)
       {
           double time=(double)(target-car[i][0])/car[i][1];

           if(prevTime < time)
           {
            fleet++;
            prevTime=time;
           }
       }
       return fleet;
    }
}