package com.skillsup.brandup.app.dao;

import com.skillsup.brandup.app.dto.MessageDTO;
import com.skillsup.brandup.app.model.Message;

import java.util.List;

public interface MessageDAO {

    void addMessage(Message message);

    List<MessageDTO> getAllMessages();

}
