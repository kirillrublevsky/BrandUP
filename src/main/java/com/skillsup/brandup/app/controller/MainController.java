package com.skillsup.brandup.app.controller;

import com.skillsup.brandup.app.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/")
public class MainController {

    @Autowired
    private MessageService messageService;

    @RequestMapping(value = "/sendMessage", method = RequestMethod.POST)
    public void sendMessage(@RequestBody String message) {
        messageService.addMessage(message);
    }

    @RequestMapping(value = "/items/{group}/{it}", method = RequestMethod.GET)
    public
    @ResponseBody
    String getItem(@PathVariable("group") String group,
                   @PathVariable("it") String item,
                   HttpServletResponse response) {
        response.setContentType("text/html");
        String send = "OK " + item + " in " + group.toUpperCase();
        return send;
    }
}
