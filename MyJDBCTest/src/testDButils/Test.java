package testDButils;

public class Test {

    public static void main(String[] args) {

        TestDBUtils tb = new TestDBUtils();
        String sql1 = "insert into department values(null,?,?)";
        String sql2 = "insert into department values(0,?,?)";
        tb.update(sql1,"金融系","挣钱");
        tb.update(sql1,"家具系","制造学生用具");
        String sql3 = "select * from department";
        tb.query(sql3);
    }
}
