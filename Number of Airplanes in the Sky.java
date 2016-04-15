/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */

class Point {
    int position;
    boolean isStart;
    Point(int pos, boolean start) {
        position = pos;
        isStart = start;
    }
    
    public static Comparator<Point> PointComparator = new Comparator<Point>() {
        public int compare(Point A, Point B) {
            if (A.position == B.position) {
                if (!B.isStart) {
                    return 1;
                }
                return -1;
            }  
            return A.position - B.position;
        }
    };

}



class Solution {
    /**
     * @param intervals: An interval array
     * @return: Count of airplanes are in the sky.
     */
    public int countOfAirplanes(List<Interval> airplanes) { 
        
        int count = 0;
        int res = 0;
        
        ArrayList<Point> array = new ArrayList<Point>();
        for (Interval interval : airplanes) {
            array.add(new Point(interval.start, true));
            array.add(new Point(interval.end, false));
        }
        Collections.sort(array,Point.PointComparator);
        
        for (Point p : array) {
            if (p.isStart) {
                count++;
            } else {
                count--;
            }
            res = Math.max(res, count);
        }
        return res;
    }
}
