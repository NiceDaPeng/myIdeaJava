package aspect;

import org.aspectj.lang.ProceedingJoinPoint;

public class Aspect1 {

    //前置建议：切点执行前执行的方法
    public void before(){
        System.out.println("Aspect1的前置建议执行了");
    }
    //后置建议：切点执行后的方法
    public void after_returningMethod(){
        System.out.println("Aspect1的后置建议执行了");
    }
    //最终建议：切点执行完的方法
//    public void afterMethod(){
//        System.out.println("最终建议执行了");
//    }
//
//    //异常建议：切点抛出异常执行的方法
//    public void after_throwing(){
//        System.out.println("异常建议执行了");
//    }
//
    //环绕建议：
    public void around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("Aspect1环绕通知的前半部分");
        pjp.proceed();
        //FileterOfChain.Dofilete(req,resp);
        System.out.println("Aspect1环绕通知的后半部分");
    }
}
