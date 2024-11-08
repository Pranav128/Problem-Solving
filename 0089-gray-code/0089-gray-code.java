class Solution {
    public List<Integer> grayCode(int n) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        al.add(0);
        int limit = (int) Math.pow(2,n)-1;
        for(int i=1; ;i++){
            int g_code = i^(i>>1);   //google it (It is formula for calculationg grey code)
            if(g_code > limit){
                break;
            }
            al.add(g_code);
        }
        return al;
    }
}