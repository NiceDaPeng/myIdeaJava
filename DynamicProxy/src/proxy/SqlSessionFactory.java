package proxy;

public class SqlSessionFactory {

    public SqlSession openSession(boolean flag){
        return new SqlSession();
    }

    public SqlSession openSession(){
        return this.openSession(false);
    }
}
