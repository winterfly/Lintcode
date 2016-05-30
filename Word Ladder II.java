public class Solution {
    /**
      * @param start, a string
      * @param end, a string
      * @param dict, a set of string
      * @return a list of lists of string
      */
    
    private List<String> getNextWords(String word, Set<String> dict) {
        ArrayList<String> list = new ArrayList<>();
        char[] chars = word.toCharArray();
        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < word.length(); i++) {
                if (c == word.charAt(i)) {
                    continue;
                }
                chars[i] = c;
                String nextWord = new String(chars);
                if (dict.contains(nextWord)) {
                    list.add(nextWord);
                }
                chars[i] = word.charAt(i);
            }
        }
        return list;
    }
    
    private void bfs(String start, String end, Set<String> dict, HashMap<String, List<String>> preMap, HashMap<String, Integer> distance) {
        Queue<String> queue = new LinkedList<String>();
        queue.offer(start);
        distance.put(start, 0);
        
        int curDist = 0, minDist = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (curDist == minDist) {
                return;
            }
            curDist++;
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                List<String> nextWords = getNextWords(word, dict);
                for (String nextWord : nextWords) {
                    
                    if (!preMap.containsKey(nextWord)) {
                        preMap.put(nextWord, new ArrayList<String>());
                    }
                    preMap.get(nextWord).add(word);
                    
                    if (distance.containsKey(nextWord)) {
                        continue;
                    }
                
                    distance.put(nextWord, curDist);
                    queue.offer(nextWord);
                    
                    if (nextWord.equals(end)) {
                         minDist = curDist;
                    }
                }
            }
        }
    }
    
    private void dfs(List<List<String>> res, List<String> list, String word, String start, HashMap<String, List<String>> preMap, HashMap<String, Integer> distance) {
        
        if (word.equals(start)) {
            List<String> listNow = new ArrayList<String>(list);
            Collections.reverse(listNow);
            res.add(listNow);
            return;
        }
        
        for (String preWord : preMap.get(word)) {
            if (distance.containsKey(preWord) && distance.get(preWord) == distance.get(word) - 1) {
                list.add(preWord);
                dfs(res, list, preWord, start, preMap, distance);
                list.remove(list.size() - 1);
            }
        }
        
    }
       
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        
        dict.add(end);
        
        HashMap<String, Integer> distance = new HashMap<>();
        HashMap<String, List<String>> preMap = new HashMap<>();
        bfs(start, end, dict, preMap, distance);
        
        List<List<String>> res = new ArrayList<>();
        List<String> list = new ArrayList<>();
        list.add(end);
        
        dfs(res, list, end, start, preMap, distance);
        
        return res;
    }
}
