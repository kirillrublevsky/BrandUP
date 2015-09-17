package com.skillsup.brandup.app.service.impl;

import com.skillsup.brandup.app.dao.MessageDAO;
import com.skillsup.brandup.app.dto.MessageDTO;
import com.skillsup.brandup.app.model.Message;
import com.skillsup.brandup.app.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageDAO messageDAO;

    @Override
    @Transactional
    public void addMessage(Message message) {
        messageDAO.addMessage(message);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MessageDTO> getAllMessages() {
        return messageDAO.getAllMessages();
    }

}
