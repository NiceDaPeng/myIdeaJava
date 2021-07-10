package com.dpj.service;

import com.dpj.dao.BooksDao;
import com.dpj.domain.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.annotation.Resources;

@Transactional
@Service("bookServiceImpl")
public class BooksServiceImpl implements BooksService{

    public BooksDao getBooksDao() {
        return booksDao;
    }


    public void setBooksDao(BooksDao booksDao) {
        this.booksDao = booksDao;
    }

    @Autowired
    @Qualifier("booksDao")
    @Resource(name="")
    private BooksDao booksDao;
    @Override
    public void regist(Books books) {

        booksDao.save(books);
//        throw new RuntimeException("test");
    }

    @PostConstruct
    public void init(){
        System.out.println("BooksServiceImpl.init");
    }

    @PreDestroy
    public void destory(){
        System.out.println("BooksServiceImpl.destory");
    }
}
