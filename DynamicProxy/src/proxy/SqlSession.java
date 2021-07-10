package proxy;

import domain.Student;

public class SqlSession {

    //预先将mapper.xml文件解析的过程
    static {
        //读取mapper.xml文件内容并解析内容
        //mapper根标签
    }

    public void insert(String sqlid, Object obj) {

        /**
         * 1,导包
         * 2，加载驱动
         * 3，获取链接（连接池方式管理）
         * 4，通过传递的sqlid找寻sql语句（解析xml文件）
         * 5，创建状态参数
         * 6，将sql语句和提供的参数信息组合完整。
         * 7，单独写一个方法，做的事情是反射，分析sql语句#{key}，反射到obj对象找value
         * 8，执行操作，executeUpdate（）
         * 7，关闭
         */
        System.out.println("我是sqlSession中的insert方法");
    }

    //可以理解为这个类的对象是以前我们MyBatis提供的sqlSession对象。
    //只不过现在我们自己尝试创建这个类。

}
