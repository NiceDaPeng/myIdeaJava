package com.dpj;


import com.dpj.dao.BooksDao;
import com.dpj.domain.Books;
import com.dpj.service.BooksService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {
    @Test
    public void test1(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        BooksDao booksDao = (BooksDao) ctx.getBean("booksDao");
        Books book = new Books();
        book.setBname( "MyBatis进阶" );
        book.setBprice( 120.3F );
        book.setBcount( 100 );
        booksDao.save( book );
    }

    @Test
    public void test2(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        BooksService booksService = (BooksService) ctx.getBean("booksService");
        Books book = new Books();
        book.setBname("nice1");
        book.setBprice(123.23F);
        book.setBcount(100);
        booksService.regist(book);
    }
}
