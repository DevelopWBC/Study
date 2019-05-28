package Async;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author Wangzhiwen
 * @ClassName MyAsyncServlet
 * @Description
 * @Date 2019/5/28 15:28
 * @Version 1.0
 */
//注解方式，开启异步请求
@WebServlet(name = "Async",value = "/Async",asyncSupported = true)
public class MyAsyncServlet extends HttpServlet {

    //异步请求，主线程接收到请求后处理会立马释放掉。业务逻辑给另外一个线程处理
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("主线程："+Thread.currentThread()+"   "+System.currentTimeMillis());
        //获取异步线程的上下文
        AsyncContext asyncContext = req.startAsync();
        //线程异步业务逻辑处理
        asyncContext.start(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("异步线程："+Thread.currentThread()+"   "+System.currentTimeMillis());
                    //业务逻辑处理

                    //通知处理完毕
                    asyncContext.complete();
                    System.out.println("异步线程："+Thread.currentThread()+"   "+System.currentTimeMillis());
                }catch (Exception e){

                }
            }
        });
        System.out.println("主线程："+Thread.currentThread()+"   "+System.currentTimeMillis());
    }
}
