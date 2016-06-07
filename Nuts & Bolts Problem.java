/**
 * public class NBCompare {
 *     public int cmp(String a, String b);
 * }
 * You can use compare.cmp(a, b) to compare nuts "a" and bolts "b",
 * if "a" is bigger than "b", it will return 1, else if they are equal,
 * it will return 0, else if "a" is smaller than "b", it will return -1.
 * When "a" is not a nut or "b" is not a bolt, it will return 2, which is not valid.
*/
public class Solution {
    /**
     * @param nuts: an array of integers
     * @param bolts: an array of integers
     * @param compare: a instance of Comparator
     * @return: nothing
     */
    public void sortNutsAndBolts(String[] nuts, String[] bolts, NBComparator compare) {
        if (nuts == null || bolts == null || nuts.length != bolts.length) {
            return;
        }
        quickSort(nuts, bolts, compare, 0, nuts.length - 1);
    }
    
    void quickSort(String[] nuts, String[] bolts, NBComparator compare, int l, int r) {
        if (l >= r) {
            return;
        }
        
        int index = partition(nuts, bolts[l], compare, l, r);
        partition(bolts, nuts[index], compare, l, r);
        
        quickSort(nuts, bolts, compare, l, index - 1);
        quickSort(nuts, bolts, compare, index + 1, r);
    }    
    
    void swap(String[] array, int i, int j) {
        String temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    int partition(String[] array, String pivot, NBComparator compare, int l, int r) {
        for (int i = l; i <= r; i++) {
            if (compare.cmp(array[i], pivot) == 0 || compare.cmp(pivot, array[i]) == 0) {
                swap(array, i, l);
                break;
            }
        }
        
        String now = array[l];
        int left = l;
        int right = r;
        while (left < right) {
            while (left < right && (compare.cmp(array[right], pivot) == 1 || compare.cmp(pivot, array[right]) == -1)) {
                right--;
            }
            array[left] = array[right];
            while (left < right && (compare.cmp(array[left], pivot) == -1 || compare.cmp(pivot, array[left]) == 1)) {
                left++;
            }
            array[right] = array[left];
        }
        array[left] = now;
        
        return left;
    }
    
};
