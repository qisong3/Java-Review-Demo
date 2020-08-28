package cn.errison.feature.demo.boxing;

import java.util.ArrayList;
import java.util.List;

public class Demo1 {

    private static int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0};

    private static void boxing() {
        List<Integer> list = new ArrayList<>();
        for (int in : array) {
            list.add(in);
        }
        for (int out : list) {
            System.out.println(out);
        }
    }


    public static void main(String[] args) {
        boxing();
    }
}
