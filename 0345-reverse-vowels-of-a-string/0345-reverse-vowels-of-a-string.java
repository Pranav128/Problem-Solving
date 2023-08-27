class Solution {
    public String reverseVowels(String s) {
        if(s.length()<=1)
        {
            return s ;
        }

        char arr[] = s.toCharArray();
        for( int i =0,j = s.length()-1;  i<j ;i++,j--)
        {
            while(i<j && !isVowel(arr[i]))
            {
                i++ ;
            }
            while(i<j && !isVowel(arr[j]))
            {
                j--;
            }
            if(i<=j)
            {
                swap( i, j, arr);
            }           
        }
        return new String(arr);
    }
    public static boolean isVowel(char ch)
    {
        return (ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'||
                ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch=='U');
    }
    public static void swap(int i,int j, char[] sb)
    {
        char temp = sb[i];
        sb[i] = sb[j] ;
        sb[j]  =temp ;
    }
}