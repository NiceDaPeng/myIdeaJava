package day2105;

import java.util.*;

public class Test {

    public static void main(String[] args) {

        HashMap<String, Collection<String>> songs = new HashMap<String,Collection<String>>();
        ArrayList<String> wangfei = new ArrayList<>();
        wangfei.add("《红豆》");
        wangfei.add("《传奇》");
        wangfei.add("《容易受伤的女人》");
        songs.put("王菲",wangfei);
        Set<Map.Entry<String, Collection<String>>> entries1 = songs.entrySet();
        ArrayList<String> zxy = new ArrayList<>();
        zxy.add("《一路上有你》");
        zxy.add("《吻别》");
        zxy.add("《一千个伤心的理由》");
        songs.put("张学友", zxy);

        Set<Map.Entry<String, Collection<String>>> entries = songs.entrySet();
        for (Map.Entry entry :
                entries) {
            System.out.println(entries);
            System.out.println();
        }
    }
}
