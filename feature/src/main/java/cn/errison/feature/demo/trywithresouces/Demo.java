package cn.errison.feature.demo.trywithresouces;

import java.io.*;

public class Demo {

    private static void readBefore(){
        BufferedReader src = null;
        BufferedWriter dest = null;
        try {
            src  = new BufferedReader(new FileReader("in.txt"));
            dest = new BufferedWriter(new FileWriter("out.txt"));
            String line;
            while ((line = src.readLine()) != null) {
                System.out.println(line);
                dest.write(line);
                dest.newLine();  // write a newline
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {            // always close the streams
            try {
                if (src != null) src.close();  // close() throw IOException
                if (dest != null) dest.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        try {
            src.read();   // Trigger IOException: Stream closed
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static void readAfter(){
        try (BufferedReader src  = new BufferedReader(new FileReader("in.txt"));
             BufferedWriter dest = new BufferedWriter(new FileWriter("out.txt"))) {
            String line;
            while ((line = src.readLine()) != null) {
                System.out.println(line);
                dest.write(line);
                dest.newLine();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        // src and dest automatically close.
        // No need for finally to explicitly close the resources.
    }

    public static void main(String[] args) {
        readBefore();
        readAfter();
    }
}
