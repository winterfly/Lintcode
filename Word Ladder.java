public class Solution {
    /**
      * @param start, a string
      * @param end, a string
      * @param dict, a set of string
      * @return an integer
      */
      
    ArrayList<String> findNextWords(String word, Set<String> dict) {
        ArrayList<String> nextWords = new ArrayList<String>();
        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == c) {
                    continue;
                }
                
                char[] chars = word.toCharArray();
                chars[i] = c;
                String nextWord = new String(chars);
                
                if (dict.contains(nextWord)) {
                    nextWords.add(nextWord);
                }
            }
        }
        return nextWords;
    }
      
    public int ladderLength(String start, String end, Set<String> dict) {
        if (start == null || end == null || dict == null) {
            return 0;
        }
        
        if (start.equals(end)) {
            return 1;
        }
        
        dict.add(end);
        HashSet<String> hashSet = new HashSet<String>();
        Queue<String> queue = new LinkedList<String>();
        hashSet.add(start);
        queue.add(start);
        
        int length = 1;
        while (!queue.isEmpty()) {
            length++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                ArrayList<String> nextWords = findNextWords(word, dict);
                for (String nextWord : nextWords) {
                    if (hashSet.contains(nextWord)) {
                        continue;
                    }
                    if (nextWord.equals(end)) {
                        return length;
                    }
                    hashSet.add(nextWord);
                    queue.offer(nextWord);
                } 
            }
        }
        
        return 0;
    }
}
