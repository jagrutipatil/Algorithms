/*
Merge Intervals

Given a collection of intervals, merge all overlapping intervals.

Example
Given intervals => merged intervals:

[                     [
  [1, 3],               [1, 6],
  [2, 6],      =>       [8, 10],
  [8, 10],              [15, 18]
  [15, 18]            ]
]

Logic: 1. sort the numbers based on start time, then compare if next start lies between previous start and end. keep track of max end and min end, and add start, end to result when current tuple's start does not contains in previous range.
*/
/**
 * Definition of Interval:
 * public class Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */

class Solution {
    /**
     * @param intervals, a collection of intervals
     * @return: A new sorted interval list.
     */
    public List<Interval> merge(List<Interval> intervals) {
    	List<Interval> result = new ArrayList<Interval>();
 		if (intervals.size() == 0) 
 			return result;
 		Collections.sort(intervals, new Comparator<Interval>() {
 		    public int compare(Interval i1, Interval i2) {
 		        return i1.start - i2.start;
 		    }
 		});
 		int start = intervals.get(0).start;
 		int end = intervals.get(0).end;
        
 		for (int i = 1; i < intervals.size(); i++) {
 			if (intervals.get(i).start <= end) {
 				end = Math.max(intervals.get(i).end, end);
 			} else {
 				result.add(new Interval(start, end));
 				start = intervals.get(i).start;
 				end = intervals.get(i).end;
 			}
 		}
 		result.add(new Interval(start, end));
 		return result;
    }

}