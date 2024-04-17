package com.sai.designPatterns.islands;

public class IslandsAdj {


    private static boolean isSafe(int[][] nums, int i, int j) {
        int m = nums.length;
        int n = nums[0].length;
        return i >= 0 && j >= 0 && i < m && j < n && nums[i][j] == 1;
    }

    private static void dfs(int[][] nums, int i, int j) {

        if (!isSafe(nums, i, j)) return;

        nums[i][j] = -1;

        dfs(nums, i + 1, j);
        dfs(nums, i - 1, j);
        dfs(nums, i, j + 1);
        dfs(nums, i, j - 1);
        dfs(nums, i + 1, j - 1);
        dfs(nums, i - 1, j - 1);
        dfs(nums, i + 1, j + 1);
        dfs(nums, i - 1, j - 1);

    }

    private static int solve(int[][] nums) {
        int m = nums.length;
        int n = nums[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (nums[i][j] == 1) {
                    dfs(nums, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] nums = {
                {0, 1, 1, 1},
                {0, 1, 1, 1},
                {1, 0, 1, 0},
        };
        System.out.println(solve(nums));
    }

}
