import java.util.ArrayList;
import java.util.List;

/**
 * Created by liunian on 15-10-30.
 */
public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (newInterval == null) {
            return intervals;
        }

        List<Interval> results = new ArrayList<Interval>();

        if (intervals == null || intervals.size() <= 0) {
            results.add(newInterval);
            return results;
        }

        int start = getStart(intervals, newInterval);
        if (start == -1) {
            intervals.add(newInterval);
            return intervals;
        }

        int end = getEnd(intervals, newInterval);
        if (end == -1) {
            intervals.add(0, newInterval);
            return intervals;
        }

        for (int i = 0; i < start; i++) {
            results.add(intervals.get(i));
        }

        int mergeStart = Math.min(intervals.get(start).start, newInterval.start);
        int mergerEnd = Math.max(intervals.get(end).end, newInterval.end);
        Interval mergerInterval = new Interval(mergeStart, mergerEnd);
        results.add(mergerInterval);

        for (int i = end + 1; i < intervals.size(); i++) {
            results.add(intervals.get(i));
        }
        return results;

    }

    int getStart(List<Interval> intervals, Interval newInterval) {
        int i = 0;
        for (; i < intervals.size(); i++) {
            Interval tmpInterval = intervals.get(i);

            if (tmpInterval.end >= newInterval.start) {
                break;
            }
        }

        if (i >= intervals.size()) {
            return -1;
        } else {
            return i;
        }
    }


    int getEnd(List<Interval> intervals, Interval newInterval) {
        int i = intervals.size() - 1;
        for (; i >= 0; i--) {
            Interval tmpInterval = intervals.get(i);

            if (tmpInterval.start <= newInterval.end) {
                break;
            }
        }
        if (i < 0) {
            return -1;
        } else {
            return i;
        }
    }

    public static void main(String[] args) {
        InsertInterval tmp = new InsertInterval();

        List<Interval> lists = new ArrayList<Interval>();
        lists.add(new Interval(1, 5));
//        lists.add(new Interval(3, 4));
//        lists.add(new Interval(6, 7));
//        lists.add(new Interval(8, 10));
//        lists.add(new Interval(1, 5));


        List<Interval> results = tmp.insert(lists, new Interval(6, 9));


        for (int i = 0; i < results.size(); i++) {
            Interval ele = results.get(i);
            System.out.println("[" + ele.start + ", " + ele.end + "]");
        }


    }

}
