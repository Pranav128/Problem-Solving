class Node{
    Node children[]=new Node[26];
    boolean eow;
}
class Trie {
    private Node root;
    public Trie() {
        this.root=new Node();
    }
    
    public void insert(String word) {
        Node curr=root;
        for(int i=0;i<word.length();i++){
            int ind=word.charAt(i)-'a';
            if(curr.children[ind]==null){
                curr.children[ind]=new Node();
            }
            curr=curr.children[ind];
        }
        curr.eow=true;
    }
    
    public boolean search(String word) {
        Node curr=root;
        for(int i=0;i<word.length();i++){
            int ind=word.charAt(i)-'a';
            if(curr.children[ind]==null){
                return false;
            }
            curr=curr.children[ind];
        }
        return curr.eow;
    }
    
    public boolean startsWith(String word) {
        Node curr=root;
        for(int i=0;i<word.length();i++){
            int ind=word.charAt(i)-'a';
            if(curr.children[ind]==null){
                return false;
            }
            curr=curr.children[ind];
        }
        return true;
    }
}
