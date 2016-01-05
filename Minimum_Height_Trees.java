public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Set<Integer>> arr = new ArrayList<Set<Integer>>();
        
        if (n == 1) {
            return Collections.singletonList(0);
        }

        for (int i = 0; i < n ; i++)
            arr.add(new HashSet<Integer>());

        for (int[] edge: edges) {
            arr.get(edge[0]).add(edge[1]);
            arr.get(edge[1]).add(edge[0]);
        }

        List<Integer> leaves = new ArrayList<Integer>();        
        for (int i = 0; i < n; i++) {
            if (arr.get(i).size() == 1) {
                leaves.add(i);
            }
        }
        while (n > 2) {
            n = n - leaves.size();
            List<Integer> newLeaves = new ArrayList<Integer>();
            for (int i = 0; i < leaves.size(); i++) {
                int j = arr.get(leaves.get(i)).iterator().next();
                arr.get(j).remove(leaves.get(i));
                if (arr.get(j).size() == 1) {
                    newLeaves.add(j);
                }   
            }
            leaves = newLeaves;
        }
        return leaves;
    }
}