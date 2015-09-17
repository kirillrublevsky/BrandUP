package com.skillsup.brandup.app.dao.impl;

import com.skillsup.brandup.app.dao.MessageDAO;
import com.skillsup.brandup.app.dto.MessageDTO;
import com.skillsup.brandup.app.model.Message;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MessageDAOImpl implements MessageDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addMessage(Message message) {
        entityManager.persist(message);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<MessageDTO> getAllMessages() {
        List<Message> messages = entityManager.createQuery("SELECT m FROM Message m").getResultList();
        return convertToDTOList(messages);
    }

    private MessageDTO convertMessageToMessageDTO(Message message) {
        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setId(message.getId());
        messageDTO.setDate(message.getDate());
        messageDTO.setName(message.getName());
        messageDTO.setPhone(message.getPhone());
        messageDTO.setEmail(message.getEmail());
        messageDTO.setContents(message.getContents());

        return messageDTO;
    }

    private List<MessageDTO> convertToDTOList(List<Message> messages) {
        List<MessageDTO> messagesDTO = new ArrayList<>();
        for (Message message : messages) {
            messagesDTO.add(convertMessageToMessageDTO(message));
        }
        return messagesDTO;
    }


}
