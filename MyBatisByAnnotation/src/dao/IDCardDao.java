package dao;

import domain.IDCard;
import domain.Person;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface IDCardDao {

    //根据cardid查询身份信息并查处对应的人员信息
    @Results(
            id="selectidcard",
            value={
                    @Result(property = "cardid",column = "cardid",id = true),
                    @Result(property = "address",column = "address"),
                    @Result(
                            property = "person",javaType = Person.class,column = "cardid",
                            one=@One(select = "selectOnePerson",fetchType = FetchType.LAZY)
                    )
            }
    )
    @Select("select * from idcard where cardid = #{cardid}")
    IDCard selectOne(String cardid);

    //设计一个辅助方法来查询的信息
    @Select("select * from person where cardid=#{cardid}")
    Person selectOnePerson(String cardid);


    //设计一个方法用来查询所有的身份证信息包含对应的人员信息
    @Select("select * from idcard")
    @ResultMap("selectidcard")
    List<IDCard> selectAll();
}
