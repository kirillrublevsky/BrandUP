package com.skillsup.brandup.service.impl;

import com.skillsup.brandup.dao.MessageDAO;
import com.skillsup.brandup.dao.entity.Message;
import com.skillsup.brandup.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageDAO messageDAO;

    public MessageDAO getMessageDAO() {
        return messageDAO;
    }

    public void setMessageDAO(MessageDAO messageDAO) {
        this.messageDAO = messageDAO;
    }

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
