class Point implements Comparable<Point>{
    int x,y;
    int square;
    Point(int x,int y,int square)
    {
        this.x=x;
        this.y=y;
        this.square=square;
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public int compareTo(Point p){
            return (int)p.square-(int)this.square;
    }

}
class Solution {
     public int[][] kClosest(int[][] points, int k) {
        int ans[][]=new int[k][2];
        PriorityQueue<Point> pq =  new PriorityQueue<Point>();
        for(int i=0;i<points.length;i++){
            int square=points[i][0]*points[i][0] + points[i][1]*points[i][1];
            pq.offer(new Point(points[i][0],points[i][1],square));
            while(pq.size()>k){
                pq.poll();
            }
        }
        for(int i=0;i<k;i++){
            Point temp=pq.poll();
            ans[i][0]=temp.getX();
            ans[i][1]=temp.getY();
        }
        return ans;
    }
    public int[][] kClosest2(int[][] points, int k) {
        int ans[][]=new int[k][2];
        PriorityQueue<Point> pq =  new PriorityQueue<Point>((a,b)->a.square-b.square);
        for(int i=0;i<points.length;i++){
            int square=points[i][0]*points[i][0] + points[i][1]*points[i][1];
            pq.offer(new Point(points[i][0],points[i][1],square));
        }
        for(int i=0;i<k;i++){
            Point temp=pq.poll();
            ans[i][0]=temp.getX();
            ans[i][1]=temp.getY();
        }
        return ans;
    }
}