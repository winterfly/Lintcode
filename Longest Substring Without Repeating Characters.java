public class Solution {
    /**
     * @param s: a string
     * @return: an integer 
     */
    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        while (i < s.length()) {
            while (j < s.length() && !map.containsKey(s.charAt(j))) {
                map.put(s.charAt(j), j);
                j++;
            }
            max = Math.max(max, j - i);
            if (j < s.length()) {
                int index = map.get(s.charAt(j));
                for (int k = i; k <= index; k++) {
                    map.remove(s.charAt(k));
                }
                i = index + 1;
            } else {
                break;
            }
        }
        return max;
    }
}
