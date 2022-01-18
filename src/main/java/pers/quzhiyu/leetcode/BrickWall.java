package pers.quzhiyu.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BrickWall {
    public int leastBricks(List<List<Integer>> wall) {
        int size = wall.size();
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < wall.size(); i++) {
            int n = 0;
            for (int j = 0; j < wall.get(i).size()-1; j++) {
                n += wall.get(i).get(j);
                map.put(n,map.getOrDefault(n,0) + 1);
            }
        }
        int result = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            result = Math.max(result,entry.getValue());
        }
        return size - result;
    }

    public static void main(String[] args) {

    }
}
