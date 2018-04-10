
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class pro56 {
    static class Interval {

      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }

        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> ans = new ArrayList<Interval>();
        if(intervals.size()==0) return ans;
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start-o2.start;
            }
        });
        Interval curInterval = intervals.get(0);
        for(Interval interval:intervals){
            if(interval.start<=curInterval.end && interval.start>=curInterval.start){
                curInterval.end = Math.max(curInterval.end,interval.end);
            }
            else if(interval.start>curInterval.end){
                ans.add(curInterval);
                curInterval = interval;
            }
        }
        ans.add(curInterval);
        return ans;
    }
    static public void main(String argv[]){
        List<Interval> list = new ArrayList<>();
        new pro56().merge(list);
    }
}
