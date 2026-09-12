class Solution {
    public boolean rotateString(String s, String goal) {
        
        String Str=s+s;
        if(s.length() == goal.length() && Str.contains(goal))
        {
            return true;
        }
        else{
            return false;
        }
    }
}