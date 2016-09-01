/*
	Segment Tree Query II

	For an array, we can build a SegmentTree for it, each node stores an extra attribute count to denote the number of elements in the the array which value is between interval start and end. (The array may not fully filled by elements)

	Design a query method with three parameters root, start and end, find the number of elements in the in array's interval [start, end] by the given root of value SegmentTree.

	Example
	For array [0, 2, 3], the corresponding value Segment Tree is:


                     [0, 3, count=3]
                     /             \
          [0,1,count=1]             [2,3,count=2]
          /         \               /            \
   [0,0,count=1] [1,1,count=0] [2,2,count=1], [3,3,count=1]
	
	query(1, 1), return 0

	query(1, 2), return 1

	query(2, 3), return 2

	query(0, 2), return 2

	Logic: Same as binary search tree, if range is between left and right node interval then take addition of left to mid and mid to right. Also consider edge cases like given start is less than root's start and given end is more than root's end.

*/
/**
 * Definition of SegmentTreeNode:
 * public class SegmentTreeNode {
 *     public int start, end, count;
 *     public SegmentTreeNode left, right;
 *     public SegmentTreeNode(int start, int end, int count) {
 *         this.start = start;
 *         this.end = end;
 *         this.count = count;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     *@param root, start, end: The root of segment tree and 
     *                         an segment / interval
     *@return: The count number in the interval [start, end]
     */
    public int query(SegmentTreeNode root, int start, int end) {
    	if (root == null || start > end)
    		return 0;
    	if (end > root.end)
    	    end = root.end;
        
        if (start < root.start)
            start = root.start;
            
    	if (root.start == start && root.end == end)
    		return root.count;

    	int mid = (root.start + root.end)/2;

    	if (end <= mid) {
    		return query(root.left, start, end);
    	} else if (mid < start) {
    		return query(root.right, start, end);
    	} 
    	return query(root.left, start, mid) + query(root.right, mid+1, end);
    }
}