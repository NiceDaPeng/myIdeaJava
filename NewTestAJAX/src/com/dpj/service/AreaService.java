package com.dpj.service;

import com.dpj.dao.AreaDao;
import com.dpj.domain.Area;

import java.util.ArrayList;

public class AreaService {

    private AreaDao dao = new AreaDao();

    public ArrayList<Area> queryAreaByCid(String cid){
        return dao.queryAreaByCid(cid);
    }
}
