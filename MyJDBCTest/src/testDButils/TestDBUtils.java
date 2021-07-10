package testDButils;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TestDBUtils extends QueryRunner {
    private static QueryRunner qr = new QueryRunner();
    public int update(String sql, Object... args) {
        Connection con = null;
        int len = 0;
        try {
            con = ConnUtils.getCon();
            len = qr.update(con, sql, args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println(con);
        return len;
    }



    public List<Map<String,Object>> query(String sql,Object... args){
        Connection conn = null;
        List<Map.Entry> list = new ArrayList<>();
        try {
            conn = ConnUtils.getCon();
            List<Map<String, Object>> query = qr.query(conn, sql, new MapListHandler(), args);
            for (int i = 0; i < query.size(); i++) {
                Map<String, Object> stringObjectMap = query.get(i);
                Set<Map.Entry<String, Object>> entries = stringObjectMap.entrySet();
                for (Map.Entry en :
                        entries) {
                   list.add(en);
                }
            }

            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i));
            }
            System.out.println(conn);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
