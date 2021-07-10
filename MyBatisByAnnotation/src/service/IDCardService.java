package service;

import dao.IDCardDao;
import domain.IDCard;
import util.MyUtil;

import java.util.List;

public class IDCardService {

    private IDCardDao dao = MyUtil.getMapper(IDCardDao.class);

    //设计一个方法用来查询一个身份证信息
    public IDCard selectOne(String cardid){
        return dao.selectOne(cardid);
    }

    //设计一个方法用来查询所有的身份信息以及对应的人员信息
    public List<IDCard> selectAll(){
        return dao.selectAll();
    }
}
