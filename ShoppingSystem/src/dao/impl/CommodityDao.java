package dao.impl;

import dao.BasicDao;
import domain.Commodity;

import java.util.List;

public class CommodityDao extends BasicDao {

    //根据id查询所有商品信息
    public List<Commodity> selectMoreCommodity(String id){
        String sql = "select `commid`,`commname`,`commprice`,`cateid` from commodity where cateid=?";
        List<Commodity> commodities = queryMore(sql, Commodity.class, id);
        return commodities;
    }

    //设计一个方法用来查询一条商品记录
    public Commodity getOneCommodity(String commid){
        String sql = "SELECT COMMID,COMMNAME,COMMPRICE,CATEID FROM COMMODITY WHERE COMMID=?";
        return queryOne(sql, Commodity.class, commid);
    }
}
