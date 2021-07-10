package testutil;

public class TestStringBuilder {

    public static void main(String[] args) {

        StringBuilder builder = new StringBuilder();//创建一个16个容量的字符数组
        builder.append(1);
        builder.append('a');
        builder.append(true);
        builder.append(1234567798328322L);
        builder.append(13.24);
        builder.append("helloworld");


//        char charAt = builder.charAt(1);
//        System.out.println(builder);
//        System.out.println(charAt);
//        builder.codePointAt(1);
//        builder.insert(1,"goodTime");
//        System.out.println(builder);
//        builder.deleteCharAt(0);
        System.out.println(builder);
        builder.delete(3, 5);
        System.out.println(builder);

        builder.reverse();
        System.out.println(builder);

        builder.replace(0,7,"******");
        System.out.println(builder);
        String str = "ab1cedesdeefe";
        String a = str.replace("e", "*");
        System.out.println(a);
        //String类字符串常用的方法 ：
        // 截取 substring（0）substring[0,1)     添加元素， concat(value)
        // 删除，获取元素 charAt() codePointAt() ，
        // 反转，替换replace("","") replaceAll("","")replace();
        // 有效元素个数length，空间长度  判断  （startsWith(),endsWith())
        //  toCharArray(),转换为一个字符数组
        //valueOf()将基本数据类型转换为String类型。
        //toUpperCase（）将所有字母都大写 toLowerCase（）将所有字母都小写
        //trim（）去掉前后空格
        //split（）按照正则表达式拆分

        //stringBuilder中常用的方法
        //append()在后面追加元素，insert（int index，value）
        // 在某个位置插入元素，value表示可以插入任意基本类型的元素
        //删除元素一段元素 delete（int start,int end），删除某个位置的元素,deleteCharAt(int idnex)
        //获取元素 charAt（int index）获取某个位置的元素
        /*
        * 反转元素  reverse（）
        * 获取有效元素个数：length（）
        * 获取空间容量  capacity（）
        *
        * StringBuffer类和StringBuilder类中的方法几乎是一样的，创建对象的方式也几乎是一样的
        * 只不过StringBuffer是在1.0版本的时候出现的线程安全的
        * StringBuilder是在1.5版本出现的非线程安全的。
        *
        * String是不可变字符串  StringBuffer和StringBuilder是可变字符串。
        * 一般我们在对字符串有频繁的操作的时候可以选用StringBuffer或者是StringBuilder
        *
        * StringBuffer和StringBuilder都可以直接通过创建对象的方式创建一个字符串对象
        * String 里面有带StringBuffer的构造方法也有带StringBuilder的构造方法
        * StringBuffer和StringBuilder中都有带String的构造方法。
        * */




    }
}
