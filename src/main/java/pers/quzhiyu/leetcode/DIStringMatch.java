package pers.quzhiyu.leetcode;

public class DIStringMatch {
    public int[] diStringMatch(String s) {
        int n = s.length();
        int left = 0, right = n;
        int[] res = new int[n+1];
        char[] arr = s.toCharArray();
        if(arr[0] == 'I') {
            res[0] = left++;
        }else {
            res[0] = right--;
        }
        for(int i = 1; i < arr.length; i ++) {
            if(arr[i] == 'I') {
                res[i] = left++;
            }else {
                res[i] = right--;
            }
        }
        res[n] = left;

        return res;
    }

    public static void main(String[] args) {
        String input = "IDID";
        int[] ints = new DIStringMatch().diStringMatch(input);
        System.out.println(ints);
    }
}
