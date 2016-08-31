/*
Max Points on a Line

Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.

Example
Given 4 points: (1,2), (3,6), (0,0), (1,3).

The maximum number is 3.

Complexity: O(n2)

Logic: 1. Two points are on same line if their slope is same, so maintain slope vs count,
       2. Also count if there are any identical points
       3. Keep track of maximum points on same line while calculating slope of each point with another point
*/
/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
 
public class Solution {
    public int maxPoints(Point[] points) {
 		Map<Double, Integer> map = new HashMap<Double, Integer>();
 		int maxPoints = 0, samePoints = 0;

 		for (Point pi : points) {
 			samePoints = 0;
 			map.clear();
 			for (Point pj : points) {
 				if (pi.x == pj.x && pi.y == pj.y) {
 					samePoints++;
 					continue;
 				}
                double slope = Double.NaN;
                if (pi.x != pj.x)
 				   slope = (pi.y-pj.y)*1.0 / (pi.x-pj.x);
 				   
 				updateMap(map, slope);
 			}
 			
 			maxPoints = Math.max(maxPoints, samePoints);
 			for (int p : map.values()) 
 				maxPoints = Math.max(maxPoints, p + samePoints);
 		} 
 		return maxPoints;      
    }

    void updateMap(Map<Double, Integer> map, double slope) {
    	int value = 1;
    	if (map.containsKey(slope)) {
    		value = map.get(slope)+1;
    	}
    	map.put(slope, value);
    }
}