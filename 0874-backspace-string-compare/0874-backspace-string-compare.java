class Solution {
    public boolean backspaceCompare(String s, String t) 
    {
       return ans(s).equals(ans(t)) ;   
    }
    public static String ans(String str)
    {
        StringBuilder sbr = new StringBuilder();
        for (char c : str.toCharArray()) {  
            if (c != '#') {
                sbr.append(c);
            } else if (sbr.length() != 0) {
                sbr.deleteCharAt(sbr.length() - 1);
            }
        }
        return sbr.toString();
    }
}

/*
 public boolean backspaceCompare(String S, String T) {
        return stackSolution(S).equals(stackSolution(T));
    }
    
    private String stackSolution(String str) {
        Stack<Character> stack = new Stack<Character>();
        
        for (char c : str.toCharArray()) {
		
            if (c != '#') {
                stack.push(c);
				
            } else if (!stack.isEmpty()) {
                stack.pop();
            }
        }
        return stack.toString();
    }*/