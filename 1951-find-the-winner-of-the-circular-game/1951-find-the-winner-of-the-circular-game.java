class Solution {
    public int findTheWinner(int n, int k) 
    {
        LinkedList<Integer> ll = new LinkedList<>();
        for(Integer i=1 ;i<=n ;i++)
        {
            ll.add(i);
        }
        int index = 0;
        while(ll.size() > 1)
        {
            index = (index + k - 1) % ll.size();
            ll.remove(index);
        }
        return ll.peek();
        
    }
}