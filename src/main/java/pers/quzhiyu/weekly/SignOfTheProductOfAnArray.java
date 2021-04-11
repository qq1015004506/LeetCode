package pers.quzhiyu.weekly;

public class SignOfTheProductOfAnArray {
    public int arraySign(int[] nums) {
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                return 0;
            }
            if(nums[i] < 0) {
                cnt++;
            }
        }
        return cnt % 2 == 1 ? -1 : 1;
    }

    public static void main(String[] args) {
        int[] nums = {-1,-2,-3,-4,3,2,1};
        int i = new SignOfTheProductOfAnArray().arraySign(nums);
        System.out.println(i);
    }
}
