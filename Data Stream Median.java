public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: the median of numbers
     */
    public int[] medianII(int[] nums) {
        int[] medians = new int[nums.length];
        if (nums.length == 0) {
            return medians;
        }
        
        PriorityQueue<Integer> leftMaxHeap = new PriorityQueue<Integer>();
        PriorityQueue<Integer> rightMinHeap = new PriorityQueue<Integer>();
        
        int median = nums[0];
        medians[0] = median;
        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];
            
            if (current <= median) {
                leftMaxHeap.offer(-current);
            } else {
                rightMinHeap.offer(current);
            }
            
            if (leftMaxHeap.size() < rightMinHeap.size() - 1) {
                leftMaxHeap.offer(-median);
                median = rightMinHeap.poll();
            } else if (leftMaxHeap.size() > rightMinHeap.size()) {
                rightMinHeap.offer(median);
                median = -leftMaxHeap.poll();
            }
            medians[i] = median;
        }
        
        return medians;
        
    }
}
