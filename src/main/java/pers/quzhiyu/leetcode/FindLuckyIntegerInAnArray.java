package pers.quzhiyu.leetcode;

public class FindLuckyIntegerInAnArray {
    int[] array = new int[501];
    public int findLucky(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            array[arr[i]]++;
        }

        for (int i = array.length - 1; i > 0; i--) {
            if(i == array[i]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {2,2,3,4};
        int lucky = new FindLuckyIntegerInAnArray().findLucky(array);
        System.out.println(lucky);
    }
}
