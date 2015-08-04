package com.skillsup.brandup.dao;

import com.skillsup.brandup.dao.entity.Message;

public interface MessageDAO {

    void addMessage(Message message);
    Message getMessageById(Integer id);
    Integer getLastMessageId();
}
