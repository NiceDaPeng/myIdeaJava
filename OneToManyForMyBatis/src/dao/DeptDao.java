package dao;

import domain.Dept;
import org.apache.ibatis.session.SqlSession;
import util.MyUtil;

import java.util.List;

public class DeptDao {


    //设计一个方法,根据deptno查询部门信息，以及部门中所有员工的信息
    private SqlSession sqlSession = MyUtil.getSqlSession(true);

    public Dept selectOne(Integer deptno){
       return sqlSession.selectOne("selectOne",deptno);
    }

    //设计一个方法用来查询所有的部门信息包含员工信息
    public List<Dept> selectAll(){
        return sqlSession.selectList("selectAll");
    }
}
