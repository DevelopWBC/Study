package springbootcase.demo.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springbootcase.demo.pojo.data.test1.Student;
import springbootcase.demo.pojo.vo.ResponseResult;
import springbootcase.demo.service.TestService;
import springbootcase.demo.util.ResponseUtil;

@RestController
@RequestMapping(value = "/student")
public class StudentController {

    private final TestService service;

    @Autowired
    public StudentController(TestService service){
        this.service = service;
    }

    @GetMapping(value = "/getStudent/{id}")
    public ResponseResult getStudent(@PathVariable(value = "id") Integer id){
        Student student = service.getStudent(id);
        return ResponseUtil.success(student);
    }

    @GetMapping(value = "/save")
    public ResponseResult save(Student student){
        service.saveStudent(student);
        return ResponseUtil.success();
    }

}
