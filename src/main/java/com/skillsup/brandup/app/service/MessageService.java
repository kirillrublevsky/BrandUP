package com.skillsup.brandup.app.service;

public interface MessageService {

    void addMessage(String contents);

    String getMessageById(Integer id);

    Integer getLastMessageId();
}
