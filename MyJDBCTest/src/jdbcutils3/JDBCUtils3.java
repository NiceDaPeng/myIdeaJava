package jdbcutils3;

import java.lang.reflect.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
@SuppressWarnings("all")
public abstract class JDBCUtils3<T> {
    private Class type;
    public JDBCUtils3(){
        //子类创建对象的时候默认调用父类的无参构造
        Class<? extends JDBCUtils3> clazz = this.getClass();//这个this是子类的对象--正在new的对象。
        Type t = clazz.getGenericSuperclass();
        //为什么要强转？因为为了调用getActualTypeArguments()方法
        ParameterizedType pt = (ParameterizedType) t;
        Type[] types = pt.getActualTypeArguments();
        type =(Class)types[0];
    }

    public static int updataData(String sql,Object... args) throws Exception {
        Connection conn = GetConnectionOfDataSource.getConn();
        PreparedStatement pre = conn.prepareStatement(sql);
        if (args != null && args.length > 0){
            for (int i = 1;i < args.length;i++){
                pre.setObject(i+1,args[i]);
            }
        }
        int len = pre.executeUpdate();
        pre.close();
        return len;
    }

    public <T>T  getBean(String sql,Object... args) throws Exception {
        Connection conn = GetConnectionOfDataSource.getConn();
        PreparedStatement pre = conn.prepareStatement(sql);
        if (args != null && args.length > 0){
            for (int i = 1;i < args.length;i++){
                pre.setObject(i+1,args[i]);
            }
        }
        T t = (T) type.newInstance();
        ResultSet rs = pre.executeQuery();

        if (rs.next()){
            //结果集的元数据对象，（元数据：描述结果集中的数据的数据）
            ResultSetMetaData metaData = rs.getMetaData();//结果集记录的是列数，和字段的名称
            int conuts = metaData.getColumnCount();//有几列说明有几个属性
            for (int i = 0; i < conuts; i++) {
                Field field = type.getDeclaredField(metaData.getColumnName(i+1));
                field.setAccessible(true);
                field.set(t,rs.getObject(i+1));
            }
            rs.close();
            pre.close();
            /*Field field = type.getDeclaredField("");
            Class<? extends Field> fiedType = field.getClass();
            String fieldName = field.getName();
            String firstName = fieldName.substring(0, 1);
            String endName = fieldName.substring(1);
            String fName = firstName.toUpperCase();
            Method method = type.getMethod("set" + fName + endName);
            Constructor<? extends Field> constructor = fiedType.getConstructor(String.class);
            String value = "haha";
            method.invoke(type,constructor.newInstance(value));*/

        }
        return t;
    }

    public List<T> getBeanList(String sql, Object... args) throws Exception {
        ArrayList<String> list = new ArrayList<>();
        Connection conn = GetConnectionOfDataSource.getConn();
        PreparedStatement pre = conn.prepareStatement(sql);
        if (args != null && args.length > 0){
            for (int i = 1;i < args.length;i++){
                pre.setObject(i+1,args[i]);
            }
        }
        T t = (T) type.newInstance();
        ResultSet rs = pre.executeQuery();

        if (rs.next()){
            //结果集的元数据对象，（元数据：描述结果集中的数据的数据）
            ResultSetMetaData metaData = rs.getMetaData();//结果集记录的是列数，和字段的名称
            int conuts = metaData.getColumnCount();//有几列说明有几个属性
            for (int i = 0; i < conuts; i++) {
                Field field = type.getDeclaredField(metaData.getColumnName(i+1));
                field.setAccessible(true);
                field.set(t,rs.getObject(i+1));
            }

            rs.close();
            pre.close();
            /*Field field = type.getDeclaredField("");
            Class<? extends Field> fiedType = field.getClass();
            String fieldName = field.getName();
            String firstName = fieldName.substring(0, 1);
            String endName = fieldName.substring(1);
            String fName = firstName.toUpperCase();
            Method method = type.getMethod("set" + fName + endName);
            Constructor<? extends Field> constructor = fiedType.getConstructor(String.class);
            String value = "haha";
            method.invoke(type,constructor.newInstance(value));*/

        }
        return (List<T>) list;
    }
}
