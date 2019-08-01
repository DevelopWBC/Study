package springbootcase.demo.web.asyncController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Wangzhiwen
 * @ClassName AsyncController
 * @Description：异步处理
 * @Date 2019/7/22 15:18
 * @Version 1.0
 */
@RequestMapping(value = "/async")
@RestController
public class AsyncController {
/*    private final PeopleService peopleService;

    @Autowired
    public AsyncController(PeopleService peopleService){
        this.peopleService = peopleService;
    }

    @GetMapping(value = "/one")
    public Map<String,Object> one(){
        Map<String,Object> res = new HashMap<>();
        try {
            String async = peopleService.async();
            res.put("msg",async);
            res.put("code",0);
            return res;
        } catch (InterruptedException e) {
            e.printStackTrace();
            res.put("msg","error");
            return res;
        }
    }

    @GetMapping(value = "/list")
    public Result list(){
        int page = 0;
        int size = 100;
        Result result = peopleService.listUser(page, size);
        return result;
    }


    @GetMapping(value = "/save")
    public Map<String,Object> save(){
        Map<String,Object> res = new HashMap<>();
        peopleService.saveOneUser();
        res.put("code",0);
        res.put("msg","success");
        return res;
    }*/
}
