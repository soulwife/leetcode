/**
Given a binary tree, determine if it is 
height-balanced
.

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: true
Example 2:


Input: root = [1,2,2,3,3,null,null,4,4]
Output: false
Example 3:

Input: root = []
Output: true
 

Constraints:

The number of nodes in the tree is in the range [0, 5000].
-104 <= Node.val <= 104

 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func isBalanced(root *TreeNode) bool {
	if root == nil {
		return true
	}
	left := dfs(root.Left)
	right := dfs(root.Right)

	return abs(left, right) <= 1 && isBalanced(root.Left) && isBalanced(root.Right)
}

func dfs(root *TreeNode) int {
	if root == nil {
		return 0
	}
	return max(dfs(root.Left), dfs(root.Right)) + 1
}

func abs(val1, val2 int) int {
	minus := val1 - val2
	if minus > 0 {
		return minus
	}
	return -minus
}

func max(val1, val2 int) int {
	if val1 > val2 {
		return val1
	}
	return val2
}
