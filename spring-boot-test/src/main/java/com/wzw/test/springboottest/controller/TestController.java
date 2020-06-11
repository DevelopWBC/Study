package com.wzw.test.springboottest.controller;

import com.wzw.test.springboottest.ssid.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;



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
    @PostMapping(value = "/test")
    public String methodName(Test test){
        System.out.println(test.getName());
        System.out.println(test.getFile());
        return "success";
    }

    @GetMapping(value = "/path")
    public Response<CertificateInfo<PageAText,PageASource>> test(){
        PageA text = new PageA();
        PageA source = new PageA();

        PageAText pageAText = new PageAText();
        pageAText.setPage_a(text);
        PageASource pageASource = new PageASource();
        pageASource.setPage_a(source);

        CertificateInfo<PageAText,PageASource> info = new CertificateInfo<>();

        //info.setText(pageAText);
        //info.setSource(pageASource);
        return new Response<>(info);
    }

    @GetMapping(value = "/path2")
    public Response<Object> tes2t(){
        PageA text = new PageA();
        PageA source = new PageA();

        PageAText pageAText = new PageAText();
        pageAText.setPage_a(text);
        PageASource pageASource = new PageASource();
        pageASource.setPage_a(source);

        CertificateInfo<PageAText,PageASource> info = new CertificateInfo<>();

        //info.setText(pageAText);
        //info.setSource(pageASource);
        return new Response<>();
    }
}
