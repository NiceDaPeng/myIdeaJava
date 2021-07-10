package com.dpj.domain;

import java.util.*;

public class User {
    private String name;
    private String password;
    private String[] arrays;
    private Set<String> set;
    private Date birthday;

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", arrays=" + Arrays.toString(arrays) +
                ", set=" + set +
                ", grade=" + grade +
                ", gradeList=" + gradeList +
                ", map=" + map +
                ", gradeMap=" + gradeMap +
                '}';
    }

    private Grade grade;
    private List<Grade> gradeList;
    private Map<String,String> map;
    private Map<String,Grade> gradeMap;

    public User() {
    }

    public User(String name, String password, String[] arrays, Set<String> set, Grade grade, List<Grade> gradeList, Map<String, String> map, Map<String, Grade> gradeMap) {
        this.name = name;
        this.password = password;
        this.arrays = arrays;
        this.set = set;
        this.grade = grade;
        this.gradeList = gradeList;
        this.map = map;
        this.gradeMap = gradeMap;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String[] getArrays() {
        return arrays;
    }

    public void setArrays(String[] arrays) {
        this.arrays = arrays;
    }

    public Set<String> getSet() {
        return set;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public List<Grade> getGradeList() {
        return gradeList;
    }

    public void setGradeList(List<Grade> gradeList) {
        this.gradeList = gradeList;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public Map<String, Grade> getGradeMap() {
        return gradeMap;
    }

    public void setGradeMap(Map<String, Grade> gradeMap) {
        this.gradeMap = gradeMap;
    }
}
