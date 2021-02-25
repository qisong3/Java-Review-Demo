package cn.errison.leetcode.common.util;

/**
 *
 */
public class ArrayUtils {


    public static  void print(int[] array){
        for (int num: array){
            System.out.print(num + ", ");
        }
        System.out.println();
    }

    public static void print(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + ", ");
            }
            System.out.println();
        }
    }
}
