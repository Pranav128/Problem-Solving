class WordDictionary {
    WordDictionary children[]=new WordDictionary[26];
    boolean eow;

    public WordDictionary(){
    }
    
    public void addWord(String word) {
        WordDictionary curr=this;
        for(int i=0;i<word.length();i++){
            int ind=word.charAt(i)-'a';
            if(curr.children[ind]==null){
                curr.children[ind]=new WordDictionary();
            }
            curr=curr.children[ind];
        }
        curr.eow=true;
    }
    
    public boolean search(String word) {
        WordDictionary curr=this;
        for(int i=0;i<word.length();++i){
            char c=word.charAt(i);
            if(c=='.'){
                for(WordDictionary temp : curr.children){
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