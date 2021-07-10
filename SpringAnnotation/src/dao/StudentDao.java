package dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@Repository("studentDao")
public class StudentDao {

    public List<Map<String, Object>> select(String ssex){
        System.out.println("我是dao层，我执行了");
        JdbcTemplate template = new JdbcTemplate();
        return null;
    }
}
