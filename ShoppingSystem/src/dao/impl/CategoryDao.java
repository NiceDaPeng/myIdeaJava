package dao.impl;

import dao.BasicDao;
import domain.Category;
import domain.Commodity;

import java.util.ArrayList;
import java.util.List;

public class CategoryDao extends BasicDao {

    //查询所有的种类
    public List<Category> selectMoreCategory(){
        String sql = "select cateid,catename from category";
        List<Category> categories = queryMore(sql, Category.class);
        return categories;
    }


}
