package dao;

import domain.IDCard;
import domain.Person;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface PersonDao {

    //设计一个方法通过注解的方式来查询一个人员的信息，包括身份证信息
    @Select("select * from person where pid = #{pid}")
    @Results(
            id="selectOne",
            value={
                    @Result(property = "pid",column = "pid",id=true),
                    @Result(property = "pname",column = "pname"),
                    @Result(property = "idCard",javaType = IDCard.class,column = "cardid",one=@One(select = "selectIDCard",fetchType = FetchType.LAZY))
            }
    )
    Person selectOne(Integer pid);

    @Select("select * from idcard where cardid=#{cardid}")
    IDCard selectIDCard(@Param("cardid") String cardid);

    //设计一个方法用来查询所有的员工信息
    @Select("select * from person")
    @ResultMap("selectOne")
    List<Person> selectAll();
}
