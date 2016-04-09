/* Question:
  Given an array of integers, how many three numbers can be found
  in the array, so that we can build an triangle whose three edges
  length is the three numbers that we find?
*/

public class Solution {
    /**
     * @param S: A list of integers
     * @return: An integer
     */
    public int triangleCount(int S[]) {
        Arrays.sort(S);
        int left, right, res = 0;
        for (int i = 0; i < S.length; i++) {
            left = 0;
            right = i - 1;
            while (left < right) {
                if (S[left] + S[right] > S[i]) {
                    res += right - left;
                    right--;
                } else {
                    left++;
                }
            }
        }
        return res;
        
    }
}
