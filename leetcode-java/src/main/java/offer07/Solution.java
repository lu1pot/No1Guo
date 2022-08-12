package offer07;

public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = new TreeNode(preorder[0]);
        int root_idx = biSearch(inorder, root.val); //找到root在中序的位置，确定左右子树范围

        root.left = doBuildTree(preorder,inorder,1,root_idx - 1,0,root_idx - 1);
        root.right = doBuildTree(preorder,inorder,root_idx + 1, preorder.length - 1, root_idx + 1, inorder.length - 1);
        return root;
    }

    public TreeNode doBuildTree(int[] preorder, int[] inorder,
                                int pre_start,int pre_end,
                                int in_start,int in_end) {

        if(pre_start > pre_end){
            return null;
        }
        TreeNode node = new TreeNode(preorder[pre_start]);

        int node_idx = biSearch(inorder, node.val);
        int left_size = node_idx - in_start;
        node.left = doBuildTree(preorder,inorder,pre_start + 1,pre_start + left_size,in_start,node_idx - 1);
        node.right = doBuildTree(preorder,inorder,node_idx + 1, in_end,node_idx + 1,in_end);

        return node;
    }


    private int biSearch(int[] nums,int target){
        int left,right,mid;
        left = 0;
        right = nums.length;
        while (true){
            mid = (left+right) >>> 1;
            if(target > nums[mid]){
                left = mid + 1;
            }
            if(target < nums[mid]){
                right = mid - 1;
            }
            if(left > right){
                break;
            }
            if(target == nums[mid]){
                return mid;
            }
        }
        return -1;
    }
}
