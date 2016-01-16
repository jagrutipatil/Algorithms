public class Solution {
    public String intToRoman(int num) {
 		Map<Integer, String> map = new HashMap<Integer, String>();
 		map.put(1000, "M");
 		map.put(900, "CM");
 		map.put(500, "D");
 		map.put(400, "CD");
 		map.put(100, "C");
 		map.put(90, "XC");
 		map.put(50, "L");
 		map.put(40, "XL");
 		map.put(10, "X");
 		map.put(9, "IX");
 		map.put(5, "V");
 		map.put(4, "IV");
 		map.put(1, "I");

        List<Integer> list = new ArrayList<Integer>(map.keySet());
        Collections.sort(list);
 		StringBuilder sb = new StringBuilder();
 		for (int i = list.size()-1; i >= 0; i--) {
 			while (num >= list.get(i)) {
 				sb.append(map.get(list.get(i)));
 				num = num - list.get(i);
 			}
 		}

 		return sb.toString();
    }
}