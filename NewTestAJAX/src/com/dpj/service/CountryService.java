package com.dpj.service;

import com.dpj.dao.CountryDao;
import com.dpj.domain.Country;

import java.util.ArrayList;

public class CountryService {

    private CountryDao dao = new CountryDao();
    public ArrayList<Country> queryAllCountry(){
        return dao.queryAllCountry();
    }
}
