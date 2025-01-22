//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            System.out.println(new Solution().infixToPostfix(br.readLine().trim()));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends

    // static boolean isOperator(char c){
    //     return c=='+' || c=='-' || c=='/' || c=='*' || c=='^';
    // }
    
class Solution {
    public static String infixToPostfix(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> st = new Stack<>();
        
        for (char c : s.toCharArray()) {
            // if operand
            if (Character.isLetterOrDigit(c)) {
                sb.append(c);
            }
            // if open parenthesis
            else if (c == '(') {
                st.push(c);
            }
            // if closed parenthesis
            else if (c == ')') {
                while (!st.isEmpty() && st.peek() != '(') {
                    sb.append(st.pop());
                }
                // Ensure the stack is not empty before popping '('
                st.pop(); // pop the open parenthesis
            }
            // if operator found
            else {
                while (!st.isEmpty() && priority(st.peek()) >= priority(c)) {
                    sb.append(st.pop());
                }
                st.push(c);
            }
        }

        // pop remaining operators in stack
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        
        return sb.toString();
    }
    
    static int priority(char c) {
        if (c == '^') return 3;
        else if (c == '*' || c == '/') return 2;
        else if (c == '-' || c == '+') return 1;
        else return -1;
    }
}
