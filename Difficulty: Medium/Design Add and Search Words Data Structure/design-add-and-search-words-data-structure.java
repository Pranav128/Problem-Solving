//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            List<String> function = Arrays.asList(br.readLine().trim().split(
                " ")); // Read the first line and split by spaces
            // Second array input
            List<String> words = new ArrayList<>();
            words.add("init");
            words.addAll(Arrays.asList(br.readLine().trim().split(
                " "))); // Read the second line and split by spaces
            List<String> res = new ArrayList<>();
            WordDictionary wordDictionary = new WordDictionary();
            boolean init = false;
            for (int i = 0; i < n; i++) {
                String fn = function.get(i);
                String word = words.get(i);
                if (fn.equals("WordDictionary")) {
                    res.add("null");
                    init = true;
                }
                if (fn.equals("addWord") && init) {
                    wordDictionary.addWord(word);
                    res.add("null");
                }
                if (fn.equals("search") && init) {
                    res.add(wordDictionary.search(word) ? "true" : "false");
                }
            }
            for (String s : res) System.out.print(s + " ");
            System.out.println();
            System.out.println("~");
        }
    }
}


// } Driver Code Ends
class WordDictionary {
    WordDictionary[] children=new WordDictionary[26];
    boolean eow;
    
    public WordDictionary() {
        
    }
    
    public void addWord(String word){
        WordDictionary curr=this;    
        for(char c:word.toCharArray()){
            int ind=c-'a';
            if(curr.children[ind]==null){
                curr.children[ind]=new WordDictionary();
            }
            curr=curr.children[c-'a'];
        }
        curr.eow=true;
    }
    
    public boolean search(String word){
        WordDictionary curr=this;    
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            if(c=='.'){
                for(WordDictionary temp:curr.children){
                    if(temp!=null && temp.search(word.substring(i+1))){
                        return true;
                    }
                }
                return false;
            }
            if(curr.children[c-'a']==null){
                return false;
            }
            curr=curr.children[c-'a'];
        }
        return curr!=null && curr.eow;
    }
}

//{ Driver Code Starts.
// } Driver Code Ends