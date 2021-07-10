package service;

import dao.EmpDao;
import domain.Emp;

import java.util.ArrayList;

public class EmpService {
    private EmpDao ed = new EmpDao();
    //设计一个方法用来将用户传递来的页面，转化为Dao层需要的行索引

    public ArrayList<Emp> changePageToRowIndex(int page){
        int rowIndex = (page -1)*5;
        ArrayList<Emp> list = ed.limitPage(rowIndex);
        return list;
    }
}
