package pers.quzhiyu.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class VolumeOfHistogramLcci {
    public int trap1(int[] height) {
        int n = height.length;
        if(n == 0) {
            return 0;
        }
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(leftMax[i-1],height[i]);
        }

        rightMax[n - 1] = height[n - 1];
        for (int i = rightMax.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i+1],height[i]);
        }

        int res = 0;
        for (int i = 0; i < height.length; i++) {
            res += Math.min(leftMax[i],rightMax[i]) - height[i];
        }
        return res;
    }

    public int trap2(int[] height) {
        int ans = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        int n = height.length;
        for (int i = 0; i < n; ++i) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int left = stack.peek();
                int currWidth = i - left - 1;
                int currHeight = Math.min(height[left], height[i]) - height[top];
                ans += currWidth * currHeight;
            }
            stack.push(i);
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        int trap = new VolumeOfHistogramLcci().trap1(arr);
        System.out.println(trap);
    }
}
