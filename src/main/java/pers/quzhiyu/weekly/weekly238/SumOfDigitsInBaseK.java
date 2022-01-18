package pers.quzhiyu.weekly.weekly238;

public class SumOfDigitsInBaseK {
    public int sumBase(int n, int k) {
        int result = 0;
        char[] chars = Integer.toString(n, k).toCharArray();
        for (int i = 0; i < chars.length; i++) {
            result += chars[i]-'0';
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new SumOfDigitsInBaseK().sumBase(34, 6));
    }
}
