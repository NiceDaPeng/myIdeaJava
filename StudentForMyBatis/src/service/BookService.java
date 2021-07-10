package service;

import dao.BookDao;
import domain.Book;
import util.MySpring;

import java.util.List;

public class BookService {
    private BookDao dao = MySpring.getBean("dao.BookDao");
    //设计一个方法用来查询所有的书籍
    public List<Book> selectAll(){
        return dao.selectAll();
    }
}
