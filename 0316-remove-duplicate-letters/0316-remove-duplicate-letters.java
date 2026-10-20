class Solution {
    public String removeDuplicateLetters(String s) {

        char[] a=s.toCharArray();
        Deque<Character> stack=new ArrayDeque<>();
        HashMap<Character,Integer> map=new HashMap<>();
        int last[]=new int[26];

        for(int i=0;i<a.length;i++)
        {
            last[a[i]-'a']=i;
        }

        stack.push(a[0]);
        map.put(a[0],1);

        for(int i=1;i<a.length;i++)
        {
            if(!map.containsKey(a[i]))
            {
              while(!stack.isEmpty() && stack.peek() > a[i]  && last[stack.peek()-'a'] > i)
              {
                char remove=stack.pop();
                map.remove(remove);
             }
             stack.push(a[i]);
             map.put(a[i],1);
            }
        }
        StringBuilder arr=new StringBuilder();
        while(!stack.isEmpty())
        {
            arr.append(stack.pop());
        }
        return arr.reverse().toString();
        
    }
}