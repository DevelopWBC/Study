package com.wzw.test.springboottest.controller;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author Wangzhiwen
 */
public class Test {
    private MultipartFile file;
    private String name;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
