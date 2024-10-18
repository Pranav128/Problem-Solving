class Solution {
    public int[] beautifulArray(int n) {
        ArrayList<Integer> res = new ArrayList<>();
        divideAndConquer(res,1,1,n);
        return res.stream().mapToInt(i -> i).toArray();
    }

    static void divideAndConquer(ArrayList<Integer> res, int i, int inc, int len){
        if(i+inc > len){
            res.add(i);
            return;
        }
        divideAndConquer(res,i,2*inc,len);
        divideAndConquer(res,i+inc,2*inc,len);
    }



}