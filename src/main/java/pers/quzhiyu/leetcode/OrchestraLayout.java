package pers.quzhiyu.leetcode;

public class OrchestraLayout {
    public int orchestraLayout(int num, int x, int y) {
        // (x, y) 在 n + 1 层正方形边上 (n >= 0)
        int n = Math.min(Math.min(x, y), Math.min(num - 1 - x, num - 1 - y));
        // 计数
        long count = 0;

        // 前 n 层
        if (n > 0) {
            // 求前 n 层和
            int a1 = num - 1; // 第 1 层
            long an = a1 - (long) (n - 1) * 2; // 第 n 层
            count += ((a1 + an) << 1) * n; // 等差数列
        }

        // 点 (x, y) 在第 n + 1 层, 左上角 (n, n) 右下角 (m, m)
        int m = num - 1 - n;

        // 从上、右、下、左的顺序进行判断
        // 上边
        if (x == n && y >= n && y <= m) {
            count += (y - n + 1);
            return mode(count);
        }
        // 右边
        count += m - n + 1; // 边长
        if (y == m && x > n && x <= m) {
            count += (x - n);
            return mode(count);
        }
        // 下边
        count += (m - n); // 边长 - 1
        if (x == m && y >= n && y < m) {
            count += (m - y);
            return mode(count);
        }
        // 左边
        count += m - n; // 边长 - 1
        count += (m - x);
        return mode(count);
    }

    public int mode(long sum) {
        int r = (int) (sum % 9);
        return r == 0 ? 9 : r;
    }
}
