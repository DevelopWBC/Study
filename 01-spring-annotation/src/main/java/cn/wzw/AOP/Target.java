package cn.wzw.AOP;

/**
 * @Author Wangzhiwen
 * @ClassName Target
 * @Description：目标方法类，对哪一个方法进行增强
 * @Date 2019/5/27 11:01
 * @Version 1.0
 */
public class Target {
    //1.目标方法
    public String service(String res) throws IndexOutOfBoundsException{
        System.out.println("目标方法完成的业务逻辑。。。。。");
        throw new IndexOutOfBoundsException("异常");
    }
}
