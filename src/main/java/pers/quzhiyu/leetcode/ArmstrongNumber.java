package pers.quzhiyu.leetcode;

public class ArmstrongNumber {
    public boolean isArmstrong(int n) {
        String str = n + "";
        char[] chars = str.toCharArray();
        int num = 0, len = chars.length;
        for (int i = chars.length - 1; i >= 0; i--) {
            num += Math.pow(chars[i] - '0',len);
        }
        return n == num;
    }

    public static void main(String[] args) {
        boolean armstrong = new ArmstrongNumber().isArmstrong(153);
        System.out.println(armstrong);
    }
}
