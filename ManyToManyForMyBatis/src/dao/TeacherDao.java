package dao;

import domain.Teacher;
import org.apache.ibatis.session.SqlSession;
import util.MyUtil;

public class TeacherDao {

    private SqlSession sqlSession = MyUtil.getSqlSession(true);
    //给定一个老师的id查询老师的信息和他教的所有学生的信息
    public Teacher selectOne(Integer tid){
        return sqlSession.selectOne("selectOne",tid);
    }
}
