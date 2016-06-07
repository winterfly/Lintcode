public class Solution {
    /**
     * @param s : A string
     * @return : The length of the longest substring 
     *           that contains at most k distinct characters.
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {      
        
        if (s == null || s.length() == 0 || k <= 0) {
            return 0;
        }
        
        int max = 0;
        int i = 0, j = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        
        int count = 0;
        for (i = 0; i < s.length(); i++) {
            while (j < s.length()) {
                char c = s.charAt(j);
                if (map.containsKey(c) ) {
                    map.put(c, map.get(c) + 1);
                } else {
                    if (map.size() == k) {
                        break;
                    }
                    map.put(c, 1);
                }
                j++;
            }
            
            max = Math.max(max, j - i);
            
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) {
                    map.remove(c);
                }
            }
        }
        
        return max;
        
    }
}
