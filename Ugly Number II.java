class Solution {
    /**
     * @param n an integer
     * @return the nth prime number as description.
     */
    public int nthUglyNumber(int n) {
        int factors[] = {2, 3, 5};
        PriorityQueue<Long> queue = new PriorityQueue<Long>();
        queue.offer((long)1);
        for (int i = 1; i < n; i++) {
            long num = queue.poll();
            for (int j = 0; j < 3; j++) {
                long temp = num * factors[j];
                if (!queue.contains(temp)) {
                    queue.offer(temp);
                }
            }
        }
        return queue.poll().intValue();
    }
};
