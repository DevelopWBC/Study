package springbootcase.demo.config.rest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import springbootcase.demo.util.GSON;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * Created by MengJunlong on 2018/7/6.
 *
 * @Description RestTemplate配置类，springboot同步网络请求工具
 */
@Configuration
public class RestTemplateConfig {
    @Bean
    public static RestTemplate restTemplate(){
        RestTemplate restTemplate=new RestTemplate(simpleClientHttpRequestFactory());
        List<HttpMessageConverter<?>> list=restTemplate.getMessageConverters();
        list.set(1,new StringHttpMessageConverter(StandardCharsets.UTF_8));

        GsonHttpMessageConverter gsonConverter=new GsonHttpMessageConverter();
        gsonConverter.setGson(GSON.getGson());
        list.add(0,gsonConverter);//将GsonHttpMessageConverter放到list最前面，优先使用Gson解析Json，而不是默认的Jackson
        return restTemplate;
    }

    @Bean
    public static ClientHttpRequestFactory simpleClientHttpRequestFactory(){
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setReadTimeout(10*60*1000);//单位为ms
        factory.setConnectTimeout(10*60*1000);//单位为ms
        return factory;
    }
}
