package cn.errison.feature.demo.loop;

import java.util.*;

public class Demo1 {

    private static List<Integer> list  = Arrays.asList(1,2,3,4,5,6,7,8,9,0);

    private static void loopWithIterator(){
        for (Iterator i = list.iterator(); i.hasNext(); ){
            System.out.println(i.next());
        }
    }

    private static void loopWithIndex(){
        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }

    private static void loopWithForeach(){
        for (Integer i: list){
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        loopWithForeach();
        loopWithIndex();
        loopWithIterator();
    }

}
