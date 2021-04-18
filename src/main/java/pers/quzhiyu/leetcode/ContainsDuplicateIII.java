package pers.quzhiyu.leetcode;

public class ContainsDuplicateIII {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < k; j++) {
                if(j + i + 1 >= nums.length) {
                    break;
                }
                if(Math.abs(((long)nums[i] - (long)nums[j + i + 1])) <= t)
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] input = new int[] {-2147483648,2147483647};
        boolean b = new ContainsDuplicateIII().containsNearbyAlmostDuplicate(input, 1, 1);

        System.out.println(b);
    }
}
