package dao;

import domain.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface StudentDao {

    //设计一个方法用来新增信息的。
    @Insert("insert into student values(#{sid},#{sname},#{ssex},#{sage})")
    void insert(Student student);

    //设计一个删除单条记录的方法,方法的底层有一个代理，代理帮我们做事情。

    /**
     * 分析方法  方法的名字delete  方法的名字 sid
     *
     * 分析mapper.xml文件 根据类名字dao.StudentDao找到一个namespace，通过方法名字delete找id叫delete
     * 找到mapper的delete标签中存在的一条sql语句
     * 语句上面有参数#{sid} 利用方法传递的参数进行匹配。
     * 我们需要找到sql，并且需要知道要执行的哪个方法
     * 最后代理对象会根据delete标签去调用原来的sqlSession对象中的delete方法。
     *
     * 如果将原有的xml文件去掉改成注解的形式：那么
     * 1，类方法名和sql对应关系就简单了
     * 2，注解中的信息肯定需要写sql
     *
     * 当我们使用注解的时候，sql语句写在注解里面，那么我们执行的是哪个方法呢？所以这时候注解名就有用了
     * 注解的名字是类似以前的标签名字，是为了找到要执行的方法的
     *
     * 注解有四个：
     * @Insert
     * @Update
     * @Delete
     * @Select
     *
     *
     *如果参数有多个，可以通过@param（）来做。例如：
     * void delete(@param（"sname")Integer sid);
     *
     * 所有都设置完以后，还需要更改configuration.xml文件中的mapper配置，将原来的resource更改为class，
     * 指的就是你到我这个类里面去找这一条sql语句。
     * @param sid
     */
    @Delete("delete from student where sid=#{sid}")
    void delete(Integer sid);

    @Update({"update student set sname=#{sname},ssex = #{ssex},sage=#{sage} where sid=#{sid}"})
    void update(Student student);

    //根据sid负责读取数据库中一行数据
    @Select("select * from student where sid=#{sid}")
    Student selectOne(Integer sid);

    //设计一个方法查询多条记录
    @Select("select * from student")
    List<Student> selectAll();
}
