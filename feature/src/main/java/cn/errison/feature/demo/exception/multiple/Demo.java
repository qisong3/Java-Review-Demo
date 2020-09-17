package cn.errison.feature.demo.exception.multiple;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class Demo {

    private static void showExceptionBefore(String path) {

        try {
            FileInputStream fis = new FileInputStream(new File(path));
            byte[] bytes = path.getBytes("Utf-8");
            int len = bytes.length;
            byte b = bytes[len];
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        } catch (IndexOutOfBoundsException e3) {
            e3.printStackTrace();
        }

    }

    private static void showExceptionAfter(String path) {
        try {
            FileInputStream fis = new FileInputStream(new File(path));
            byte[] bytes = path.getBytes("Utf-8");
            int len = bytes.length;
            byte b = bytes[len];
        } catch (FileNotFoundException | UnsupportedEncodingException | IndexOutOfBoundsException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        showExceptionBefore("");
        showExceptionAfter("");
    }
}
