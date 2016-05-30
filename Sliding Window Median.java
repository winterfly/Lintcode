public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: The median of the element inside the window at each moving.
     */
    
    int median;
    void addOneElement(int current, PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
            if (current <= median) {
                maxHeap.offer(-current);
            } else {
                minHeap.offer(current);
            }
            
            if (maxHeap.size() > minHeap.size()) {
                minHeap.offer(median);
                median = -maxHeap.poll();
            } else if (maxHeap.size() < minHeap.size() - 1) {
                maxHeap.offer(-median);
                median = minHeap.poll();
            }
    }
     
    public ArrayList<Integer> medianSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (nums == null || nums.length == 0 || nums.length < k) {
            return result;
        }
        
        
        if (k == 1) {
            for (int i = 0; i < nums.length; i++) {
                result.add(nums[i]);
            }
            return result;
        }
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        
        median = nums[0];
        
        for (int i = 1; i < k; i++) {
            addOneElement(nums[i], maxHeap, minHeap);
        }
        
        result.add(median);
        
        for (int i = k; i < nums.length; i++) {
            int old = nums[i - k];
            if (median == old) {
                if (minHeap.size() == maxHeap.size()) {
                    median = -maxHeap.poll();
                } else {
                    median = minHeap.poll();
                }
            } else if (maxHeap.contains(-old)) {
                maxHeap.remove(-old);
            } else {
                minHeap.remove(old);
            }
            
            addOneElement(nums[i], maxHeap, minHeap);
            result.add(median);
        }
        
        return result;
    }
}
