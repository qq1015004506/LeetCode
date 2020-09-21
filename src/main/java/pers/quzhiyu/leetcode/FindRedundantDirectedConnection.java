package pers.quzhiyu.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindRedundantDirectedConnection {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] result = null;
        int len = edges.length;
        int[][] count = new int[len][2];
        for (int i = 0; i < edges.length; i++) {
            int out = edges[i][0];
            int in = edges[i][1];
            count[out][0]++;
            count[in][1]++;
        }



        return result;
    }
}
