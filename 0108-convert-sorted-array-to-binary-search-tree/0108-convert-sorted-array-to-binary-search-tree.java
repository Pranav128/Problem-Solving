class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0) return null;
        return createNode(nums,0,nums.length-1);
    }
    public static TreeNode createNode(int nums[], int start, int end){
        if(start>end) return null;
        int mid=(start+end)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left=createNode(nums,start,mid-1);
        node.right=createNode(nums,mid+1,end);
        return node;
    }
}