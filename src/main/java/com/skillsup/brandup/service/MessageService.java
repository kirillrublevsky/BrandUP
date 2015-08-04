package com.skillsup.brandup.service;

public interface MessageService {

    void addMessage(String contents);
    String getMessageById(Integer id);
    Integer getLastMessageId();
}
