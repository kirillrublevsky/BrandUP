package com.skillsup.brandup.controller;

import com.skillsup.brandup.dao.entity.Message;
import com.skillsup.brandup.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/")
public class MainController {

    @Autowired
    private MessageService messageService;


    @RequestMapping(value = "/sendMessage", method = RequestMethod.POST)
    public @ResponseBody Message sendMessage(@RequestBody String message) {
        messageService.addMessage(message);
        Integer lastMessageId = messageService.getLastMessageId();
        Message response = new Message();
        response.setContents("We received your message and will process it as ticket # " + lastMessageId +
                "\n\nYour message is:\n\n" + messageService.getMessageById(lastMessageId));
        return response;
    }

    @RequestMapping(value = "/items/{group}/{it}", method = RequestMethod.GET)
    public @ResponseBody String  getItem (@PathVariable("group") String group,
                                          @PathVariable ("it") String item,
                                          HttpServletResponse response){
        response.setContentType("text/html");
        String send = "OK " + item + " in "+ group.toUpperCase();
        return send;
    }
}
