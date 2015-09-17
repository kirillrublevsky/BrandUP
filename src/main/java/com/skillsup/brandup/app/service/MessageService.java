package com.skillsup.brandup.app.service;

import com.skillsup.brandup.app.dto.MessageDTO;
import com.skillsup.brandup.app.model.Message;

import java.util.List;

public interface MessageService {

    void addMessage(Message message);

    List<MessageDTO> getAllMessages();

}
