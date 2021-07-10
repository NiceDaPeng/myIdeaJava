package dao;

import domain.IDCard;
import org.apache.ibatis.session.SqlSession;
import util.MyUtil;

import java.util.List;

public class IDCardDao {

    private SqlSession sqlSession = MyUtil.getSqlSession(true);
    //查询单条记录
    public IDCard selectOne(String cardid) {
        return sqlSession.selectOne("selectOne",cardid);
    }

    //查询多条记录
    public List<IDCard> selectAll(){
        return sqlSession.selectList("selectAll");
    }
}
