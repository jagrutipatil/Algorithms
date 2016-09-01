/*
	Segment Tree Modify

	For a Maximum Segment Tree, which each node has an extra value max to store the maximum value in this node's interval.

	Implement a modify function with three parameter root, index and value to change the node's value with [start, end] = [index, index] to the new given value. Make sure after this change, every node in segment tree still has the max attribute with the correct value.

	Example
For segment tree:

                      [1, 4, max=3]
                    /                \
        [1, 2, max=2]                [3, 4, max=3]
       /              \             /             \
[1, 1, max=2], [2, 2, max=1], [3, 3, max=0], [4, 4, max=3]
if call modify(root, 2, 4), we can get:

                      [1, 4, max=4]
                    /                \
        [1, 2, max=4]                [3, 4, max=3]
       /              \             /             \
[1, 1, max=2], [2, 2, max=4], [3, 3, max=0], [4, 4, max=3]
or call modify(root, 4, 0), we can get:

                      [1, 4, max=2]
                    /                \
        [1, 2, max=2]                [3, 4, max=0]
       /              \             /             \
[1, 1, max=2], [2, 2, max=1], [3, 3, max=0], [4, 4, max=0]

Logic: Use Binary Search approach, modify the root when start == index and end == index, if end <= mid update left tree else update right tree, at the end update node's max as max of left and right tree
*/

/**
 * Definition of SegmentTreeNode:
 * public class SegmentTreeNode {
 *     public int start, end, max;
 *     public SegmentTreeNode left, right;
 *     public SegmentTreeNode(int start, int end, int max) {
 *         this.start = start;
 *         this.end = end;
 *         this.max = max
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     *@param root, index, value: The root of segment tree and 
     *@ change the node's value with [index, index] to the new given value
     *@return: void
     */
    public void modify(SegmentTreeNode root, int index, int value) {
    	if (root == null || root.start > index || root.end < index)
    		return;

    	if (root.start == index && root.end == index) {
    		root.max = value;
    		return;
    	}
    	
    	int mid = (root.start + root.end) /2;

    	if (index <= mid) {
 			modify(root.left, index, value);
    	} else if (mid < index) {
    		modify(root.right, index, value);
    	} 

    	int max = Integer.MIN_VALUE;

    	if (root.left != null)
    		max = Math.max(max, root.left.max);

    	if (root.right != null)
    		max = Math.max(max, root.right.max);

    	root.max = max;
    }
}