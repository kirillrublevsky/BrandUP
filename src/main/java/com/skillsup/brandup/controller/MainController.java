package com.skillsup.brandup.controller;

import com.skillsup.brandup.dao.entity.Message;
import com.skillsup.brandup.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class MainController {

    @Autowired
    private MessageService messageService;

    @RequestMapping(value = "sendMessage", method = RequestMethod.POST)
    public @ResponseBody Message sendMessage(@RequestBody String message) {
        messageService.addMessage(message);
        Integer lastMessageId = messageService.getLastMessageId();
        Message response = new Message();
        response.setContents("We received your message and will process it as ticket # " + lastMessageId +
                            "\n\nYour message is:\n\n" + messageService.getMessageById(lastMessageId));
        return response;
    }
}
