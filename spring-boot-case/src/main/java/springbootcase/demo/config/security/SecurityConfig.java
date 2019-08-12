package springbootcase.demo.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @Author Wangzhiwen
 * @ClassName SecurityConfig
 * @Description
 * @Date 2019/8/12 10:30
 * @Version 1.0
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * security安全框架（简易）配置
     */

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 授权，给指定角色授予不同的路径访问权限
        http.authorizeRequests().antMatchers("/").permitAll() // "/"都可以访问，不需要授权
                .antMatchers("/level1/**").hasRole("VTP1") // 指定路径让指定角色访问（数组）
                .antMatchers("/level2/**").hasRole("VIP2")
                .antMatchers("/level3/**").hasRole("VIP3");

        // 开启认证登陆，没有登陆时会被拦截跳转到指定登陆页面（框架有默认的登陆页面，不知道具体登陆页面时默认）
        //1、/login来到登陆页
        //2、重定向到/login?error表示登陆失败
        //3、更多详细规定
        //4、默认post形式的 /login代表处理登陆
        //5、一但定制loginPage；那么 loginPage的post请求就是登陆
        http.formLogin()
                .usernameParameter("user") // 登陆用户名字段名称
                .passwordParameter("pwd")  // 登陆用户密码字段名称
                .loginPage("/userlogin");  // 登陆用户指定的登陆页面（from表单）这里通过controller进行跳转。不要忘记加“/”

        // 开启自动配置的注销
        //1、访问 /logout 表示用户注销，清空session
        //2、注销成功会返回 /login?logout 页面；
        http.logout().logoutSuccessUrl("/"); //注销成功后跳转的路径（controller中的路径）

        // 开启记住我功能
        //登陆成功以后，将cookie发给浏览器保存，以后访问页面带上这个cookie，只要通过检查就可以免登录
        //点击注销会删除cookie
        http.rememberMe().rememberMeParameter("remember"); // 与登陆页面“记住我”input框字段名称相同
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 定义认证规则
        auth.inMemoryAuthentication()
                // 用户名、密码、角色名称（数组）
                .withUser("001").password("001").roles("VIP1")
                .and()
                .withUser("002").password("002").roles("VIP2")
                .and()
                .withUser("003").password("003").roles("VIP3")
                .and()
                // todo:不能以明文的方式设置用户名密码角色
                .passwordEncoder(new MyPasswordEncoder()).withUser("004").password("004").roles("VIP2");
    }
}
