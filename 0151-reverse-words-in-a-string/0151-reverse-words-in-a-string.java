class Solution {
    public String reverseWords(String s) {
        Stack<String> stack = new Stack<>();
        for(String ss : s.trim().split(" "))
        {
            if(!ss.isEmpty())
            {
            stack.push(ss);

            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty())
        {
            sb.append(stack.pop());
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}