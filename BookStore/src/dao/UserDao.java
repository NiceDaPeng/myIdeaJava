package dao;

import domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserDao {

    /**
     * 插入一条数据
     * @param user
     * @return
     */
    @Insert("insert into t_user values(#{uid},#{uname},#{upassword},#{uemail})")
    void insert(User user);

    @Select("select * from t_user where uname=#{uname}")
    User selectOne(@Param("uname") String uname);
}
