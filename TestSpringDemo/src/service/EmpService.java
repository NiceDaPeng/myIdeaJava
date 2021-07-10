package service;

import dao.EmpDao;
import domain.Emp;
import util.MyUtil;

import java.util.List;

public class EmpService {
    private EmpDao dao = MyUtil.getMapper(EmpDao.class,true);
    //设计一个方法用来实现动态查询
    public List<Emp> selectDynamic(Integer sid, String job){
        return dao.selectEmpByDynamic(sid,job);
    }
}
