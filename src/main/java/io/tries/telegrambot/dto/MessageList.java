package io.tries.telegrambot.dto;

import lombok.Data;

import java.util.List;

@Data
public class MessageList {

    private List<Message> messageItemList;

    @Data
    public static class Message {
        private String link;
        private String from;
        private List<String> tags;
    }

}


