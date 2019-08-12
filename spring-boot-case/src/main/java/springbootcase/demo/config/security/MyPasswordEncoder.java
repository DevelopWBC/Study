package springbootcase.demo.config.security;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Author Wangzhiwen
 * @ClassName MyPasswordEncoder
 * @Description
 * @Date 2019/8/12 11:56
 * @Version 1.0
 */
public class MyPasswordEncoder implements PasswordEncoder {
    /**
     * 报错:java.lang.IllegalArgumentException: There is no PasswordEncoder mapped for the id "null"
     * 原因：Spring boot 2.0.3引用的security 依赖是 spring security 5.X版本，此版本需要提供一个PasswordEncorder的实例，否则后台报错。
     * 解决：创建一个类MyPasswordEncoder 实现PasswordEncoder接口
     */

    // 没有实现加密逻辑
    @Override
    public String encode(CharSequence rawPassword) {
        return rawPassword.toString();
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return encodedPassword.equals(rawPassword.toString());
    }
}
