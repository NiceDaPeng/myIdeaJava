package test;

import domain.Student;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TestMain {
    public static void main(String[] args) {
        BeanFactory factory = new ClassPathXmlApplicationContext("ApplicationContext.xml");
//        Student student = (Student) factory.getBean("student");
//        System.out.println(student);

//        BeanFactory factory = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        //通过Spring来操作数据库
        //  JDBC原生技术
        //  有点像我们自己封装的那个ORM框架
        //  一种方案是策略模式(SpringJDBC)   JdbcTemplate
        //  一种方案是反射方式(MyBatis)      SqlSession
        //  增删改 容易
        //  查询   处理结果

        //1.跟Spring的bean工厂要一个对象  JdbcTemplate
        JdbcTemplate template = (JdbcTemplate)factory.getBean("jdbcTemplate");
        //2.让template对象执行数据库操作
        //  增
//        String sql = "insert into student values(?,?,?,?)";
//        int count = template.update(sql,9,"小拓","男",17);
//        System.out.println(count);

        //删
//        String sql = "delete from student where sid = ?";
//        int count = template.update(sql,8);
//        System.out.println(count);

        //改
//        String sql = "update student set sname = ? where sid = ?";
//        int count = template.update(sql,"小七",7);
//        System.out.println(count);


        //查询
        // 一个列(变量存储)
//        String sql = "select sname from student where sid = ?";
//        Student sage = template.queryForObject(sql,Student.class,1);//只能查询一个列
//        System.out.println(sage);

        //查询
        //  一行数据(domain对象里)  数据原有表格不存在 计算出来的(平均值 最大值 map集合)
//        String sql = "select * from student where sid = ?";
//        Student student = template.queryForObject(sql,new RowMapper<Student>(){
//            public Student mapRow(ResultSet resultSet, int i) throws SQLException {
//                Student student = new Student();
//                student.setSid(resultSet.getInt("sid"));
//                student.setSname(resultSet.getString("sname"));
//                student.setSsex(resultSet.getString("ssex"));
//                student.setSage(resultSet.getInt("sage"));
//                return student;
//            }
//        },1);
//        System.out.println(student);


        //查询多行记录
//        String sql = "select * from student";
//        List list = template.queryForList(sql);//   List<Map<String,Object>>
//        System.out.println(list);

        String sql = "select * from student";
        List<Student> list = template.query(sql,new RowMapper<Student>() {
            public Student mapRow(ResultSet resultSet, int i) throws SQLException {
                Student student = new Student();
                student.setSid(resultSet.getInt("sid"));
                student.setSname(resultSet.getString("sname"));
                student.setSsex(resultSet.getString("ssex"));
                student.setSage(resultSet.getInt("sage"));
                return student;
            }
        });
        for(Student student : list){
            System.out.println(student);
        }
    }
}
