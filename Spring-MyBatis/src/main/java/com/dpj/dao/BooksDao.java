package com.dpj.dao;

import com.dpj.domain.Books;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository("booksDao")
@Scope(scopeName = "singleton")
@Lazy(false)
//@Component("booksDao")
public interface BooksDao {

    void save(Books books);
}
