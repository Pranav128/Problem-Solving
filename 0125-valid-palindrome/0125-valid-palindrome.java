class Solution {
    public boolean isPalindrome(String s) 
    {
    //    String a = s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
    //    String b = new StringBuffer(a).reverse().toString();
    //    return a.equals(b);

    s = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        int i = 0;
        int j = s.length() - 1;
        while(i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;



    }
    
}