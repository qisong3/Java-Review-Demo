package cn.errison.feature.demo.user;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchUser {



    private static Map<String, List<String>> getMobileUsers(File file){
        Map<String, List<String>> userInfos = new HashMap<>();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file),
                    "UTF-8"));
            String lineTxt = null;
            while ((lineTxt = br.readLine()) != null) {
               if (lineTxt.contains("platform:mobile")){
                   String time = lineTxt.substring(0,19);
                   String user = lineTxt.substring(lineTxt.indexOf("email:") + 6, lineTxt.indexOf("@cgtn.com"));
                   List<String> times = userInfos.get(user);
                   if (times == null){
                       times = new ArrayList<>();
                       userInfos.put(user,times);
                   }
                   times.add(time);
               }
            }
            br.close();
        } catch (Exception e) {
            System.err.println("read errors :" + e);
        }
        return userInfos;
    }

    public static List<File> getUserFromMobile(String dir){
        List<File> files = getListFiles(new File(dir));
        Map<String, List<String>> all = new HashMap<>();
        for (File file: files){
            Map<String, List<String>> map = getMobileUsers(file);
            for (Map.Entry<String, List<String>> entry: map.entrySet()){
                if (all.containsKey(entry.getKey())){
                    all.get(entry.getKey()).addAll(entry.getValue());
                }else {
                    all.put(entry.getKey(), entry.getValue());
                }
            }
        }
        for (Map.Entry<String, List<String>> entry: all.entrySet()){
            System.out.println("User " + entry.getKey());
            List<String> times = entry.getValue();
            times.forEach(item-> System.out.println("time: " + item));
        }
        return files;
    }

    public static List<File> getListFiles(File directory) {
        List<File> files = new ArrayList<File>();
        if (directory.isFile()) {
            files.add(directory);
            return files;
        } else if (directory.isDirectory()) {
            File[] fileArr = directory.listFiles();
            for (int i = 0; i < fileArr.length; i++) {
                File fileOne = fileArr[i];
                files.addAll(getListFiles(fileOne));
            }
        }
        return files;
    }

    public static void main(String[] args) {
        getUserFromMobile("D:\\logs");
    }
}
