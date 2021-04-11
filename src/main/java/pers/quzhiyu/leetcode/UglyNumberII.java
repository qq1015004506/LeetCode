package pers.quzhiyu.leetcode;

public class UglyNumberII {
    public int nthUglyNumber(int n) {
        boolean[] arr = new boolean[1690 * 5 + 1];
        arr[1] = true;
        for (int i = 1; i <= 1690; i++) {
            if(arr[i]) {
                arr[i*2] = true;
                arr[i*3] = true;
                arr[i*5] = true;
            }
        }
        int cnt = 0, res = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]) {
                cnt++;
            }
            if(cnt == n) {
                res = i;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new UglyNumberII().nthUglyNumber(137);
    }
}
