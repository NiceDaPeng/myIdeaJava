package service.impl;

import dao.impl.BooksDao;
import domain.Books;
import service.Service;

import java.util.List;

public class BooksService implements Service {
    
   private BooksDao dao = new BooksDao();

   public List<Books> getAllBooks(){
       List<Books> books = dao.queryAllBooks();
       return books;
   }
}
