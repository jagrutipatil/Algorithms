/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
	final String delm = ",";
	final String nullStr = "#";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
    	StringBuilder stb = new StringBuilder("");
    	buildString(root, stb);    
    	return stb.toString();
    }

    void buildString(TreeNode node, StringBuilder stb) {
    	if (node == null) {
    		stb.append(nullStr).append(delm);
    	} else {
    		stb.append(node.val).append(delm);
    		buildString(node.left, stb);
    		buildString(node.right, stb);
    	}
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(delm);
        Deque<String> queue = new LinkedList<String>();
        queue.addAll(Arrays.asList(nodes));
        return buildTree(queue);
    }

    TreeNode buildTree(Deque<String> queue) {
    	String val = queue.remove();
    	if (val.equals(nullStr)) {
    		return null;
    	} else {
    		TreeNode node = new TreeNode(Integer.valueOf(val));
    		node.left = buildTree(queue);
    		node.right = buildTree(queue);
    		return node;
    	}
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));