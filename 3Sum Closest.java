public class Solution {
    /**
     * @param numbers: Give an array numbers of n integer
     * @param target : An integer
     * @return : return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] numbers ,int target) {
        if (numbers.length < 3) {
            return 0;
        }
        Arrays.sort(numbers);
        
        int min = numbers[0] + numbers[1] + numbers[2];
        for (int i = 0; i < numbers.length - 2; i++) {
            int j = i + 1, k = numbers.length - 1;
            while (j < k) {
                int temp = numbers[i] + numbers[j] + numbers[k];
                if (Math.abs(target-min) > Math.abs(target-temp)) {
                    min = temp;
                }
                if (temp == target) {
                    return temp;
                } else if (temp < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return min;
    }
}
