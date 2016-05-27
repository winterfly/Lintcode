class Solution {
    /**
     * @param n an integer
     * @return the nth prime number as description.
     */
    public int nthUglyNumber(int n) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        int p1 = 0, p2 = 0, p3 = 0;
        int cur = 1;
        int min1, min2, min3;
        while (list.size() < n) {
            while (list.get(p1) * 2 <= cur) {
                p1++;
            }
            min1 = list.get(p1) * 2;
            
            while (list.get(p2) * 3 <= cur) {
                p2++;
            }
            min2 = list.get(p2) * 3;
            
            while (list.get(p3) * 5 <= cur) {
                p3++;
            }
            min3 = list.get(p3) * 5;
            
            cur = Math.min(Math.min(min1, min2), min3);
            
            list.add(cur);
        }
        return list.get(n-1);
    }
};
