package pers.quzhiyu.leetcode;

public class Average {
    public double average(int[] salary) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        double  sum = 0;
        for (int i = 0; i < salary.length; i++) {
            sum += salary[i];
            max = Integer.max(max,salary[i]);
            min = Integer.min(min,salary[i]);
        }
        return (sum - max - min) / (salary.length - 2);
    }
}
