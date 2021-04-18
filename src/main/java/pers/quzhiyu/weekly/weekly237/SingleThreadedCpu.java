package pers.quzhiyu.weekly.weekly237;

import javafx.util.Pair;

import java.util.*;

public class SingleThreadedCpu {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        Task[] ts = new Task[n];
        for(int i = 0; i < n; i++){
            ts[i] = new Task();
            ts[i].etime = tasks[i][0];
            ts[i].ptime = tasks[i][1];
            ts[i].id = i;
        }
        Arrays.sort(ts, Comparator.comparingInt(x -> x.etime));
        PriorityQueue<Task> pq = new PriorityQueue<>(Comparator.<Task>comparingInt(x -> x.ptime).thenComparingInt(x -> x.id));
        int last = 0;
        int[] ans = new int[n];
        int wpos = 0;
        long time = 0;
        while(!pq.isEmpty() || last < n){
            if(pq.isEmpty()){
                time = Math.max(time, ts[last].etime);
            }
            while(last < n && ts[last].etime <= time){
                pq.add(ts[last++]);
            }
            Task head = pq.remove();
            ans[wpos++] = head.id;
            time += head.ptime;
        }
        return ans;
    }

    class Task{
        int etime;
        int ptime;
        int id;
    }
    public static void main(String[] args) {
        int[][] input = new int[][]{{4,2},{4,4},{3,2},{4,1}};
        int[] order = new SingleThreadedCpu().getOrder(input);
        System.out.println(order);
    }
}
