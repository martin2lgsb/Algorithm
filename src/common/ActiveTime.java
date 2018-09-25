package common;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by m2lgsb on 2018/9/25 18:46
 */
public class ActiveTime {
    public static void main(String[] args) {
        Active act1 = new Active(1, 4);
        Active act2 = new Active(3, 5);
        Active act3 = new Active(0, 6);
        Active act4 = new Active(5, 7);
        Active act5 = new Active(3, 8);
        Active act6 = new Active(5, 9);
        Active act7 = new Active(6, 10);
        Active act8 = new Active(8, 11);
        Active act9 = new Active(8, 12);
        Active act10 = new Active(2, 13);
        Active act11 = new Active(12, 14);
        List<Active> actives = new ArrayList<Active>();
        actives.add(act1);
        actives.add(act2);
        actives.add(act3);
        actives.add(act4);
        actives.add(act5);
        actives.add(act6);
        actives.add(act7);
        actives.add(act8);
        actives.add(act9);
        actives.add(act10);
        actives.add(act11);

        List<Active> bestActives = getBestActives(actives, 0, 16);
        for (int i = 0; i < bestActives.size(); i++) {
            System.out.println(bestActives.get(i));
        }
    }


    /**
     * @param actives 活动集合
     * @param startTime 教室的开始使用时间
     * @param endTime 教室的结束使用时间
     * @return
     */
    public static List<Active> getBestActives(List<Active> actives, int startTime, int endTime) {
        List<Active> bestActives = new ArrayList<Active>();
        actives.sort(null);
        int nowTime = startTime;

        for (int i = 0; i < actives.size(); i++) {
            Active act = actives.get(i);
            if (act.getStartTime() >= nowTime && act.getEndTime() <= endTime) {
                bestActives.add(act);
                nowTime = act.getEndTime();
            }
        }

        return bestActives;
    }
}

class Active implements Comparable<Active>{
    private int startTime;
    private int endTime;

    public Active(int startTime, int endTime) {
        super();
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Active [startTime=" + startTime + ", endTime=" + endTime + "]";
    }

    @Override
    public int compareTo(Active o) {
        if (this.endTime > o.getEndTime()) {
            return 1;
        } else if (this.endTime == o.endTime) {
            return 0;
        } else {
            return -1;
        }
    }
}
