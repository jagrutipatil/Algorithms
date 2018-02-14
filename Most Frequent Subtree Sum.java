/*
  Given the root of a tree, you are asked to find the most frequent subtree sum. The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself). So what is the most frequent subtree sum value? If there is a tie, return all the values with the highest frequency in any order.

Examples 1
Input:

  5
 /  \
2   -3
return [2, -3, 4], since all the values happen only once, return all of them in any order.
Examples 2
Input:

  5
 /  \
2   -5
return [2], since 2 happens twice, however -5 only occur once.
Note: You may assume the sum of values in any subtree is in the range of 32-bit signed integer.

*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {    
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        if (root != null) {
            getSum(root, map);
            List<Integer> list = getList(map);
            int[] array = new int[list.size()];            
            for (int i = 0; i < list.size(); i++) {
                array[i] = list.get(i);
            }
            return array;
        }
        return new int[0];    
    }
    
    private int getSum(TreeNode node, Map<Integer, Integer> map) {
        if (node.left == null && node.right == null) {
            updateFreq(node.val, map);
            return node.val;
        }
        
        int left = 0;
        int right = 0;
        if (node.left != null) {
            left = getSum(node.left, map);
        }

        if (node.right != null) {
            right = getSum(node.right, map);
        }
        
        updateFreq(node.val + left + right, map);
        return node.val + left + right;        
    }
    
    private void updateFreq(int sum, Map<Integer, Integer> map) {
        int freq = 1;
        if (map.containsKey(sum)) {
            freq += map.get(sum);
        }
        map.put(sum, freq);           
    }
    
    private List<Integer> getList(Map<Integer, Integer> map) {
        Integer max = Integer.MIN_VALUE;
        
        List<Integer> list = new ArrayList<Integer>();
        for (Integer key : map.keySet()) {
            if (max == map.get(key)) {
                list.add(key);
            } else if (max < map.get(key)) {
                list.clear();                
                list.add(key);
                max = map.get(key);
            }                        
        }
        return list;
    }
}
