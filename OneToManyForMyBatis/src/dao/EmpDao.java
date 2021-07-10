package dao;

import domain.Emp;
import org.apache.ibatis.session.SqlSession;
import util.MyUtil;

import java.util.List;

public class EmpDao {
    //设计一个方法，根据员工的编号，查询员工的信息和部门信息。

    private SqlSession sqlSession = MyUtil.getSqlSession(true);
    public Emp selectOne(Integer empno){
        return sqlSession.selectOne("selectOne",empno);
    }

    //设计一个方法，查询所有员工信息和部门信息
    public List<Emp> selectAll(){
        return sqlSession.selectList("selectAll");
    }
}
