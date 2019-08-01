package springbootcase.demo.config.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * @Author Wangzhiwen
 * @ClassName LogAspect
 * @Description
 * @Date 2019/5/27 11:00
 * @Version 1.0
 */
@Aspect //加上注解，代表这是一个切面类
public class LogAspect {
    //编写通知的方法，前置通知、后置通知、返回通知、异常通知、环绕通知

    //增强表达式的抽取
    @Pointcut("execution(public * springbootcase.demo.config.aop.Target.*(..))")
    public void pointCut(){}

    //1.前置通知 @Before("表达式")
    @Before(value = "pointCut()")
    public void logStart(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs(); //参数
        String name = joinPoint.getSignature().getName();//方法名称
        String kind = joinPoint.getKind();
        System.out.println("方法"+name+"已运行.."+"参数为："+ Arrays.toString(args)+kind);
    }

    //2.后置增强
    @After(value = "pointCut()")
    public void logEnd(JoinPoint joinPoint){
        System.out.println("后置增强，方法结束之后运行.....");
    }

    //3.返回通知
    @AfterReturning(value = "pointCut()",returning = "result")
    public void logReturn(JoinPoint joinPoint, Object result){
        System.out.println("返回通知，在目标方法正常返回之后运行..."+"返回值为："+result);
    }

    //4.异常通知
    @AfterThrowing(value = "pointCut()",throwing = "ex")
    public void logException(JoinPoint joinPoint, Exception ex){
        System.out.println("异常通知，目标方法发生异常后运行...."+"异常类型为："+ex.getClass());
    }

    //5.环绕通知
    //@Around(value = "pointCut()")
    //public void logAround(JoinPoint joinPoint){
   // }
}
