package pers.quzhiyu.leetcode;

public class MaxEnvelopes {
    int[] flags;
    public int maxEnvelopes(int[][] envelopes) {
        int result = 0;
        int n = envelopes.length;
        if(n == 0) {
            return 0;
        }
        int[][] helper = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(comp(envelopes[i],envelopes[j])) {
                    helper[i][j] = 1;
                }
            }
        }

        int[] contains = new int[n];
        for (int i = 0; i < n; i++) {
            count(helper,contains,i);
        }
        for (int i = 0; i < contains.length; i++) {
            result = Math.max(result,contains[i]);
        }
        return result == 0 ? 1 : result;
    }

    private int count(int[][] helper, int[] contains, int index) {
        if(contains[index] != 0)
            return contains[index];
        int[] row = helper[index];
        for (int i = 0; i < row.length; i++) {
            if (row[i] != 0) {
                contains[index] = Math.max(count(helper, contains, i) + 1, contains[index]);
            }
        }
        return contains[index] == 0 ? 1 : contains[index];
    }

    private boolean comp(int[] envelope1, int[] envelope2) {
        if(envelope1[0] > envelope2[0] && envelope1[1] > envelope2[1]) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] ints = {{5, 4}, {1, 1}, {6, 7}, {2, 3}};
        int i = new MaxEnvelopes().maxEnvelopes(ints);
        System.out.println(i);
    }
}
