class Solution {
    public String largestOddNumber(String num) {
        int ind = num.lastIndexOf('1');
        ind = Math.max(ind, num.lastIndexOf('3'));
        ind = Math.max(ind, num.lastIndexOf('5'));
        ind = Math.max(ind, num.lastIndexOf('7'));
        ind = Math.max(ind, num.lastIndexOf('9'));

        return (ind == -1)?"":num.substring(0,ind+1); 
    }
}