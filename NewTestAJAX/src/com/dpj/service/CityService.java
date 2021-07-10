package com.dpj.service;

import com.dpj.dao.CityDao;
import com.dpj.domain.City;

import java.util.ArrayList;

public class CityService {
    private CityDao dao = new CityDao();
    public ArrayList<City> queryCityByAid(String aid){
        return dao.queryCityByCid(Integer.parseInt(aid));
    }
}
