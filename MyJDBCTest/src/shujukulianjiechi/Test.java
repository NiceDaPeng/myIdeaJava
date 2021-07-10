package shujukulianjiechi;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Properties;

public class Test {
    /*
     * 原始数据库的连接问题：
     *   相当于TCP/IP协议编程的Socket，每一个客户端，每一次链接都有一个独立的Socket
     *   TCP/IP协议的特点：
     *           可靠，面向连接，安全，
     *           在连接之前有三次握手，断开连接有四次握手，等操作
     * 对于数据库连接来说：
     *   每一次连接和释放连接都是一次高成本的操作
     *   1，如果每次为了执行sql时，都是问数据库服务器要新的连接，用完之后直接释放掉，那么成本很高
     *   2，如果每一个客户端为了执行sql，都是问数据库服务器要新的连接，如果并发操作很多时，会导致数据库
     *   服务器的压力很大。对于服务器来说每一个连接都有一个Socket，都有一个线程，那么服务器的压力就非常大了，
     *   数据库服务器很可能挂掉。
     *   真实的项目中服务器不止一个，有什么web服务器，文件服务器，数据库服务器等
     *  如何解决如上的问题呢？ 可以设计一个数据库连接池，
     *   这个数据库连接池先提前准备好一些连接，等用户需要用到连接时，不用创建新的
     *   从池中直接拿一个现成的连接，就避免了三次握手的过程。
     *   当用户用完以后，放回池中，不用四次挥手的过程，给下一个人继续使用。
     * 那么数据库连接池里面放多少连接合适呢？
     *
     * 数据库连接池有几个参数
     * 1，初始化连接数,一开始准备的连接的数量是多少？ 假设是10个
     * 2，最大连接数，：数据库服务器最多能承受多少个连接？假设是100个
     * 3，增量：如果数据库连接池中的连接不够了，会有一个增量，用来表示 不够了该增加多少？直到达到100个连接
     * 那么达到了100个连接以后怎么办呢？
     *       1，让用户无限制等待，例如访问一个网站，会遇到提示说服务器繁忙，或者是打10086，会放音乐让你等待。
     *       2，等待XX时间后返回异常，告知客户端连接超时。
     *           这时候就涉及到一个等待时间。等待多长时间返回异常
     *一个项目中，连接池创建一个，但是池中的连接可以有很多个
     * 数据库连接池又称为数据源。 DataSource
     *
     * 市面上又很多数据库连接池技术：
     * 比如：
     * DBCP ：Apache  提供的数据连接池，速度相对C3P0快，但是有一些BUG
     * C3P0：速度没有DBCP快，但是很稳定
     * Proxool：是sourceforge下的开源项目数据库连接池，有监控连接池状态的功能，稳定性较C3P0差点。
     * BoneCP：目前最快的数据库连接池，但是功能不是太全。
     * Druid(德鲁伊）：阿里提供的数据库连接池，集以上三个优点于一身，但是实际并不知道是否比BoneCP快。
     * 不管是哪一种技术，目的是一样的
     * 1，连接资源重用
     * 2，对于用户来说系统的相应速度更快
     * 3，是一种新的资源分配手段。原来是从数据库服务器直接获取连接，现在是从连接池获取
     *       不会导致资源的泄露
     * 4，避免数据库直接挂掉
     *
     * 如何使用Druid数据库连接池？
     * 1，引入jar包，放到libs中并且添加到buildpath中
     * 2，方式1，手动创建数据库连接池对象 在代码中硬编码配置参数
     *      方式2，在配置文件中写配置参数
     *              在代码中用配置文件创建连接池对象。
     * druid.properties中的参数名字是固定的不是随便写的
     * url:和原来一样
     * username：数据库的用户名
     * password：数据库的密码
     * driverClassName：驱动类名
     * initialSize：初始化连接数
     * maxActive：最大连接数
     * maxWait：当池中的连接都被占用了，新用户等待的时间，如果超过了这个时间就会返回异常。
     * 并不是只有这些参数
     * maxIdle：
     * minIdle:当你系统空闲的时候，保证池中释放掉一些连接后，最少需要保留几个以备不时之需。
     * 3,获取连接对象
     *  数据库连接池对象.getConnection()
     * 4,还回去连接
     *  conn.close();
     *
     * 开源框架的使用步骤
     * 1，导入jar包
     * 2，看帮助
     * 3，调用方法使用。
     * */

    public static void main(String[] args) {
        test02();
    }

    public static void test01(){
        try {
            Properties pro = new Properties();
            pro.put("url","jdbc:mysql://localhost:3306/school");
            pro.put("username","root");
            pro.put("password","123456");
            DataSource ds = DruidDataSourceFactory.createDataSource(pro);
            System.out.println(ds.getClass());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void test02(){
        Properties pro = new Properties();
        try {
            //Test.class得到当前类的Class对象
            //getClassLoader()获取类加载器对象
            //getResourceAsStream("druid.properties"),加载资源文件，，并且把配置文件中的数据
            //封装到Properties对象中
            //资源文件的格式key=value
            pro.load(new FileInputStream("src\\druid.properties"));
            DataSource ds = DruidDataSourceFactory.createDataSource(pro);
            //从数据库连接池中拿连接
            Connection conn = ds.getConnection();
            String sql = "insert into user values(null,?,?)";
            PreparedStatement pre = conn.prepareStatement(sql);
//            pre.setString();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
