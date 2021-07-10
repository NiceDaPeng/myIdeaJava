package testinterface;

/**
 * 跟Spring要一个当前类对象
 * TestService ts = f.getBean("testService");
 * 想要在IOC的过程中让对象的属性自动DI
 * 属性可以通过构造方法和set方法进行装配（手动ref指定，自动autowire）
 * 如果这个属性是一个抽象类或者接口的形式，装配一定不是当前属性的类型，是当前属性的子类型
 * 子类型可能不止一个，那么会有什么问题呢？
 * 如果利用的是构造方法autowire=constructor的方式自动装配，先按照类型匹配，如果刚好就一个就直接赋值了。
 * 如果类型发现不止一个对应，再按照属性名与bean的name去匹配，如果匹配就成功了，
 * 如果都不匹配，就创建失败了。
 *
 * 如果是利用五参数构造方法+set方法进行自动装配，
 * 按照byName的方式，如果名字找到就装配成功，如果找不到就装配失败
 *
 * byType的形式，如果有两个以上的标签匹配，那么就会报错了，此时可以使用内部bean的方式来装配
 */
public class TestService {
    //属性
    private TestInterface ti ;

    //方式一带参数构造方法

    public TestService(TestInterface ti) {
        System.out.println("带参数的构造方法执行了");
        this.ti = ti;
    }

    //方式二五参数构造方法+set方法

    public TestService() {
        System.out.println("五参数构造方法");
    }

    public void setTi(TestInterface ti) {
        System.out.println("set方法");
        this.ti = ti;
    }
}
