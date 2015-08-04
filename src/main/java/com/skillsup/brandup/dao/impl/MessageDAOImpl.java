package com.skillsup.brandup.dao.impl;

import com.skillsup.brandup.dao.MessageDAO;
import com.skillsup.brandup.dao.entity.Message;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigInteger;

@Repository
public class MessageDAOImpl implements MessageDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public MessageDAOImpl() {
    }

    @Override
    public void addMessage(Message message){
        entityManager.persist(message);
    }

    @Override
    public Message getMessageById(Integer id){
        return (Message) entityManager.getReference(Message.class, id);
    }

    @Override
    public Integer getLastMessageId(){
        return (Integer) entityManager.createNativeQuery("SELECT MAX(message_id) FROM message").getSingleResult();
    }
}
