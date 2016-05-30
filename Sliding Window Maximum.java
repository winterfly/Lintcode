public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: The maximum number inside the window at each moving.
     */
    public ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            int now = nums[i];
            while (!deque.isEmpty() && deque.peekLast() < now) {
                deque.pollLast();
            }
            deque.offerLast(now);
            
            if (i >= k - 1) {
                result.add(deque.peekFirst());
                if (deque.peekFirst() == nums[i - k + 1]) {
                    deque.pollFirst();
                }
            }
            
        }
        
        return result;
    }
}
