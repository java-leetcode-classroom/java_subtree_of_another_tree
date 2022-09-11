# java_subtree_of_another_tree

Given the roots of two binary trees `root` and `subRoot`, return `true` if there is a subtree of `root` with the same structure and node values of `subRoot` and `false` otherwise.

A subtree of a binary tree `tree` is a tree that consists of a node in `tree` and all of this node's descendants. The tree `tree` could also be considered as a subtree of itself.

## Examples

**Example 1:**

![https://assets.leetcode.com/uploads/2021/04/28/subtree1-tree.jpg](https://assets.leetcode.com/uploads/2021/04/28/subtree1-tree.jpg)

```
Input: root = [3,4,5,1,2], subRoot = [4,1,2]
Output: true

```

**Example 2:**

![https://assets.leetcode.com/uploads/2021/04/28/subtree2-tree.jpg](https://assets.leetcode.com/uploads/2021/04/28/subtree2-tree.jpg)

```
Input: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
Output: false

```

**Constraints:**

- The number of nodes in the `root` tree is in the range `[1, 2000]`.
- The number of nodes in the `subRoot` tree is in the range `[1, 1000]`.
- $`-10^4$ <= root.val <=$10^4$`
- $`-10^4$ <= subRoot.val <= $10^4$`

## 解析

每個兩個樹的根結點root, subRoot

題目要實作一個演算法去察看 subRoot 是不是 root 的 subTree

subRoot 是 root 的 subTree 有以下幾種狀況

1. subRoot 的 tree 與 root 的 tree 相等
2. subRoot 的 tree 是 root.Left tree 的 subTree
3. subRoot 的 tree 是 root.Right tree 的 subTree

要檢驗 subRoot tree與 root  tree是否相等有幾個條件

1 root 是空的時候 , subRoot 必須是空

2 root 非空, subRoot 必須非空 , 且兩值相等

3 root 左右 subTree 與 subRoot 左右 subTree 相等 

## 程式碼

```java
class Solution {
  /**
   * Definition for a binary tree node.
   * public class TreeNode {
   *     int val;
   *     TreeNode left;
   *     TreeNode right;
   *     TreeNode() {}
   *     TreeNode(int val) { this.val = val; }
   *     TreeNode(int val, TreeNode left, TreeNode right) {
   *         this.val = val;
   *         this.left = left;
   *         this.right = right;
   *     }
   * }
   */
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
```

## 困難點

1. 要明白某一個樹是另一個樹的 subTree 的定義
2. 要理解怎麼去檢驗兩樹相等

## Solve Point

- [x]  Understand what problem would like to solve
- [x]  Analysis Complexity