package offer07;

class gf_Solution {
    public TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        if (preorder_left > preorder_right) {
            return null;
        }

        int preorder_root = preorder_left;
//        int inorder_root = 0;
//        for (int i = 0; i < inorder.length; i++) {
//            if(inorder[i] == preorder[preorder_root]){
//                inorder_root = i;
//                break;
//            }
//        }
        int inorder_root = biSearch(inorder,preorder[preorder_root]);

        TreeNode root = new TreeNode(preorder[preorder_root]);

        int size_left_subtree = inorder_root - inorder_left;

        root.left = myBuildTree(preorder, inorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left, inorder_root - 1);

        root.right = myBuildTree(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_right, inorder_root + 1, inorder_right);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        // 构造哈希映射，帮助我们快速定位根节点
        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    private int biSearch(int[] list,int target){
        int left,right,mid;
        left = 0;
        right = list.length;
        while (true){
            mid = (left+right) >>> 1;
            if(target > list[mid]){
                left = mid + 1;
            }
            if(target < list[mid]){
                right = mid - 1;
            }
            if(left > right){
                break;
            }
            if(target == list[mid]){
                return mid;
            }
        }

        return -1;
    }
}

