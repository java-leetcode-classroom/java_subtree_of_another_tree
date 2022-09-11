import java.util.HashMap;

public class Solution {
  public TreeNode createBinaryTree(String[] inputs) {
    TreeNode result = null, cur;
    HashMap<Integer, TreeNode> hash = new HashMap<>();
    int size = inputs.length;
    for (int idx = 0; idx < size; idx++) {
      int num = 0;
      String val = inputs[idx];
      if (!val.equals("null")) {
        num = Integer.parseInt(val);
      }
      if (idx == 0) {
        result = new TreeNode(num);
        hash.put(num, result);
      }
      if (hash.containsKey(num)) {
        cur = hash.get(num);
      } else {
        cur = new TreeNode(num);
        hash.put(num, cur);
      }
      if (2*idx+1 < size) {
        if (!inputs[2*idx+1].equals("null")) {
          int leftVal = Integer.parseInt(inputs[2*idx+1]);
          if (hash.containsKey(leftVal)) {
            cur.left = hash.get(leftVal);
          } else {
            cur.left = new TreeNode(leftVal);
            hash.put(leftVal, cur.left);
          }
        }
      }
      if (2*idx+2 < size) {
        if (!inputs[2*idx+2].equals("null")) {
          int rightVal = Integer.parseInt(inputs[2*idx+2]);
          if (hash.containsKey(rightVal)) {
            cur.right = hash.get(rightVal);
          } else {
            cur.right = new TreeNode(rightVal);
            hash.put(rightVal, cur.right);
          }
        }
      }
    }
    return result;
  }

  public boolean isSubtree(TreeNode root, TreeNode subRoot) {
    if (root == null) {
      return subRoot == null;
    }
    return isSameTree(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
  }
  public boolean isSameTree(TreeNode root, TreeNode subRoot) {
    if (root == null) {
      return subRoot == null;
    }
    if (subRoot != null) {
      if (root.val != subRoot.val) {
        return false;
      }
      return isSameTree(root.left, subRoot.left) && isSameTree(root.right, subRoot.right);
    }
    return false;
  }
}
