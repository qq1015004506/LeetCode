package pers.quzhiyu.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindMinDifference {
    public int findMinDifference(List<String> timePoints) {
        int[] minArrays = new int[timePoints.size()];
        for (int i = 0; i < timePoints.size(); i++) {
            String timePoint = timePoints.get(i);
            String[] split = timePoint.split(":");
            int minutes = Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
            minArrays[i] = minutes;
        }
        Arrays.sort(minArrays);
        int result = Integer.MAX_VALUE;
        for (int i = 1; i < minArrays.length; i++) {
            result = Integer.min(result,minArrays[i] - minArrays[i-1]);
        }
        result = Integer.min(result,minArrays[0] +1440 - minArrays[minArrays.length-1] );
        return result;
    }

    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("23:59");
        strings.add("00:00");
        strings.add("00:00");
        System.out.println(new FindMinDifference().findMinDifference(strings));

    }
}
