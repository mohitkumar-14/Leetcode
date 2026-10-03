class Solution {
    public int longestValidParentheses(String s) {
        char ch[]=s.toCharArray();
        Deque<Integer> stack=new ArrayDeque<>();
        stack.push(-1);
        int res=-1;
        for(int i=0;i<ch.length;i++)
        {
            if(ch[i]=='('){
                stack.push(i);
            }
            else{
                stack.pop();
                if(stack.isEmpty())
                {
                    stack.push(i);
                }
                res=Math.max(res,i-stack.peek());
            }
        }
        return res!=-1?res:0;
    }
}