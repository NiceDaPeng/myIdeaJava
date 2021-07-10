package testmain;

import dao.JDBCUtils;

import javax.sql.rowset.JdbcRowSet;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test4 {

    public static void main(String[] args) throws SQLException, IOException {

        Connection conn = JDBCUtils.getConn();
        String sql = "select photo from student where sid =1";
        PreparedStatement pre = conn.prepareStatement(sql);
        ResultSet resultSet = pre.executeQuery();
        if (resultSet.next()){
            InputStream photo = resultSet.getBinaryStream("photo");
            FileOutputStream fos = new FileOutputStream("image\\haha.jpg");
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = photo.read(bytes)) != -1){
                fos.write(bytes,0,len);
            }
        }

    }
}
