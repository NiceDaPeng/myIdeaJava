package testgeneric;

import java.util.*;

public class Test {

    public static void main(String[] args) {

        HashMap<String,ArrayList<String>> map =
                new HashMap<String, ArrayList<String>>();
        ArrayList<String> list = new ArrayList<>();
        list.add("秦兰兰");
        list.add("刁湃锦");

        ArrayList<String> list2 = new ArrayList<>();
        list2.add("刁湃锦");
        list2.add("秦兰兰");
        map.put("秦兰兰",list);
        map.put("刁湃锦",list2);

        Set<String> strings = map.keySet();
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        Collection<ArrayList<String>> values = map.values();
        for (ArrayList<String> value :
                values) {
            System.out.println(value);
        }

        Set<Map.Entry<String, ArrayList<String>>> entries = map.entrySet();
        for (Map.Entry entry :
                entries) {
            System.out.println(entry);
        }
    }

    public <T> int getValues(T t){

        return 0;
    }
}
