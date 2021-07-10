package service;

import dao.EmpDao;
import domain.Emp;

import java.util.List;

public class EmpService {

    private EmpDao dao = new EmpDao();

    public Emp selectOne(Integer empno){
        return dao.selectOne(empno);
    }

    //查询多条记录
    public List<Emp> selectAll(){
        return dao.selectAll();
    }
}
