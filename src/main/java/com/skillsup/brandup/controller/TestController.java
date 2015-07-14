package com.skillsup.brandup.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping(value = "hello", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public TestClass index() {
        return new TestClass("hello test");
    }

    public class TestClass{
        private final String value;

        public TestClass(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}
