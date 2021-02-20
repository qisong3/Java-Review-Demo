package cn.errison.leetcode.common;

import java.util.List;

public class ListUtils {

    public static void print(List<List<Integer>> matrix){
       for (List<Integer> subList: matrix){
           for (Integer integer: subList){
               System.out.print(integer);
           }
           System.out.println();
       }
    }
}
