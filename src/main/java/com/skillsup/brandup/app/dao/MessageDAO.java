package com.skillsup.brandup.app.dao;

import com.skillsup.brandup.app.model.Message;

public interface MessageDAO {

    void addMessage(Message message);

    Message getMessageById(Integer id);

    Integer getLastMessageId();
}
