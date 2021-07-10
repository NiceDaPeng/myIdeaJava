package dao;

import domain.Book;
import org.apache.ibatis.session.SqlSession;
import util.MySqlSessionFactory;

import java.util.List;

public class BookDao {

    private SqlSession sqlSession = MySqlSessionFactory.getSqlSession(true);
    //设计一个方法用来查询所有的书籍
    public List<Book> selectAll(){
        return sqlSession.selectList("selectAll");
    }
}
