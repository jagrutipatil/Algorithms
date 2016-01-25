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