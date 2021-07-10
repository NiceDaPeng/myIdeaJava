package dao.impl;

import dao.BaseDao;
import domain.Books;
import util.JdbcUtil;

import java.sql.Connection;
import java.util.List;

public class BooksDao extends BaseDao {

    //查询所有的商品信息
    public List<Books> queryAllBooks(){
        String sql = "SELECT BID,BNAME,BPRICE,BDESCRIPTION,BKID FROM BOOKS";
        List<Books> books = queryMore(sql, Books.class);
        return books;
    }
}
