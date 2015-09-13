package com.skillsup.brandup.app.service.impl;

import com.skillsup.brandup.app.dao.MessageDAO;
import com.skillsup.brandup.app.model.Message;
import com.skillsup.brandup.app.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageDAO messageDAO;

    public MessageServiceImpl() {
    }

    @Override
    @Transactional
    public void addMessage(String contents) {
        Message message = new Message();
        message.setContents(contents);
        messageDAO.addMessage(message);
    }

    @Override
    @Transactional(readOnly = true)
    public String getMessageById(Integer id) {
        Message message = messageDAO.getMessageById(id);
        return message.getContents();
    }

    @Override
    @Transactional(readOnly = true)
    public Integer getLastMessageId() {
        return messageDAO.getLastMessageId();
    }


}
