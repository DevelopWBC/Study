package springbootcase.demo.config.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import springbootcase.demo.pojo.dto.SystemMail;
import springbootcase.demo.util.SendMailUtil;

import java.util.Arrays;

/**
 * @Author Wangzhiwen
 * @ClassName LogAspect
 * @Description
 * @Date 2019/5/27 11:00
 * @Version 1.0
 */
@Aspect //加上注解，代表这是一个切面类
@Component
public class LogAspect {

    private final SendMailUtil sendMailUtil;

    @Autowired
    public LogAspect(SendMailUtil sendMailUtil){
        this.sendMailUtil = sendMailUtil;
    }

    //编写通知的方法，前置通知、后置通知、返回通知、异常通知、环绕通知

    //增强表达式的抽取
    @Pointcut("execution(public * springbootcase.demo.config.aop.Target.*(..))")
    public void pointCut(){}
    @Pointcut("execution(public * springbootcase.demo.web.controller.*.*(..)))")
    public void exceptionPointCut(){}

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

    /**
     * 邮件模块与系统在同一模块时，采用异步线程的方式发送邮件。当不在同一模块时，可以考虑发送mq消息。
     * 表现层发生异常时，发生异常信息的邮件
     * 方案一：发送异常message，类名，方法名，参数
     * 方案二：发送异常的日志文件。
     */
    //4.异常通知
    @AfterThrowing(value = "exceptionPointCut()",throwing = "ex")
    public void logException(JoinPoint joinPoint, Exception ex){
        SystemMail mail = new SystemMail();
        // 方法的参数数组
        Object[] args = joinPoint.getArgs();
        // 获取被代理对象的方法信息
        Signature signature = joinPoint.getSignature();
        // 方法名称
        String methodName = signature.getName();
        // 方法的类型
        String declaringTypeName = signature.getDeclaringTypeName();
        // 异常信息
        String message = ex.getMessage();
        mail.setSubject("系统发生异常");
        //mail.setText(declaringTypeName+"."+methodName+"请求参数："+ Arrays.toString(args)+" 异常："+ex.getClass()+":"+message);
        mail.setExceptionMsg(declaringTypeName,methodName, Arrays.toString(args),ex.getClass(),message);
        mail.setFrom("1015241415@qq.com");
        mail.setTo("wangzhiwenem@163.com");
        sendMailUtil.sendHtmlMail(mail);
        System.out.println("异常通知，目标方法发生异常后运行...."+"异常类型为："+ex.getClass());
    }

    /**
     * "目标方法名为:" joinPoint.getSignature().getName();
     * "目标方法所属类的简单类名:" joinPoint.getSignature().getDeclaringType().getSimpleName();
     * "目标方法所属类的类名:" joinPoint.getSignature().getDeclaringTypeName();
     * "目标方法声明类型:" Modifier.toString(joinPoint.getSignature().getModifiers());
     * "被代理的对象:" + joinPoint.getTarget()
     * "代理对象自己:" + joinPoint.getThis()
     */
    //5.环绕通知
    //@Around(value = "pointCut()")
    //public void logAround(JoinPoint joinPoint){
   // }
}
