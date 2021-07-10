package homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Teacher {

    int score = 100;
    int offset = 0;

    public int judgeAn(ArrayList<QuentionsBank> list,String[] arr){

        for (int i = 0; i < list.size();i++){
            if((list.get(i).getAnswer()).equals(arr[i])){
                offset += 100 / list.size();
            }
        }
        return offset;
    }

}
