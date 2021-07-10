package service;

import dao.IDCardDao;
import domain.IDCard;

import java.util.List;

public class IDCardService {
    private IDCardDao dao = new IDCardDao();
    //根据cardid查询身份证信息
    public IDCard selectOne(String cardid){
        return dao.selectOne(cardid);
    }


    //查询全部信息

    public List<IDCard> selectAll(){

        return dao.selectAll();
    }
}
