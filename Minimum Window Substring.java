public class Solution {
    /**
     * @param source: A string
     * @param target: A string
     * @return: A string denote the minimum window
     *          Return "" if there is no such a string
     */
    public String minWindow(String source, String target) {
        HashMap<Character, Integer> map0 = new HashMap<>();
        for (int i = 0; i < target.length(); i++) {
            char c = target.charAt(i);
            if (map0.containsKey(c)) {
                map0.put(c, map0.get(c) + 1);
            } else {
                map0.put(c, 1);
            }
        }
        
        HashMap<Character, Integer> map = new HashMap<>();
        int len = 0;
        for (int i = 0; i < target.length(); i++) {
            char c = target.charAt(i);
            if (!map.containsKey(c)) {
                len++;
                map.put(c, 0);
            }
        }
        
        int j = 0;
        int count = 0;
        int min = Integer.MAX_VALUE;
        int st = 0, ed = source.length();
        
        for (int i = 0; i < source.length(); i++) {
            while (j < source.length() && count != len) {
                char c = source.charAt(j);
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                    if (map.get(c) == map0.get(c)) {
                        count++;
                    }
                }
                j++;
            }
            
            if (count == len) {
                if (j - i < min) {
                    min = j - i;
                    st = i;
                    ed = j;
                }
            } 
            
            char c = source.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == map0.get(c) - 1) {
                    count--;
                }
            }
        }
        
        if (min == Integer.MAX_VALUE) {
            return "";
        }
        
        return source.substring(st, ed);
    }
}
