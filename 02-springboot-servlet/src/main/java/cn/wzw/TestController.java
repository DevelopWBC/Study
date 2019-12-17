package cn.wzw;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author Wangzhiwen
 */
@RestController
public class TestController {
    /**
     *
     * @author Wangzhiwen
     * @param
     * @return
     */
    @GetMapping(value = "/test/{name}")
    public String test1(@PathVariable String name, @RequestBody Map<String,String> request){
        System.out.println(name);
        System.out.println(request);
        return "success";
    }
}
