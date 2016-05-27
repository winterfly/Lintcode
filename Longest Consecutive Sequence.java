public class Solution {
    /**
     * @param nums: A list of integers
     * @return an integer
     */
    public int longestConsecutive(int[] num) {
        HashSet<Integer> hashSet = new HashSet<Integer>();
        for (int i = 0; i < num.length; i++) {
            hashSet.add(num[i]);
        }
        
        int res = 0;
        for (int i = 0; i < num.length; i++) {
            if (hashSet.contains(num[i])) {
                int count = 1;
                Queue<Integer> list = new LinkedList<Integer>();
                list.offer(num[i]);
                hashSet.remove(num[i]);
                while (!list.isEmpty()) {
                    int number = list.poll();
                    for (int j = -1; j <= 1; j += 2) {
                        int nearNum = number + j;
                        if (hashSet.contains(nearNum)) {
                            list.add(nearNum);
                            hashSet.remove(nearNum);
                            count++;
                        }
                    }
                }
                res = Math.max(res, count);
            }
        }
        
        return res;
    }
}
