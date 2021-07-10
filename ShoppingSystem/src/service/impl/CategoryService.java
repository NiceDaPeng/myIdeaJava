package service.impl;

import dao.impl.CategoryDao;
import dao.impl.CommodityDao;
import domain.Category;
import domain.Commodity;
import util.MySpring;

import java.util.List;

public class CategoryService {


    private CategoryDao dao = MySpring.getBean("dao.impl.CategoryDao");
    private CommodityDao commodao = MySpring.getBean("dao.impl.CommodityDao");

    public List<Category> selectMore(){
        return dao.selectMoreCategory();
    }

    //根据品类号查询所有该品类下的所有商品
    public List<Commodity> getMoreCommodityByCateid(String cateid){
        List<Commodity> commodities = commodao.selectMoreCommodity(cateid);
        return commodities;
    }

    //设计一个方法根据商品id查询商品详情信息
    public Commodity getCommodityByCommid(String commid){
        return commodao.getOneCommodity(commid);
    }
}
