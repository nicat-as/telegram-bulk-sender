package io.tries.telegrambot.dto;

import lombok.Data;

@Data
public class ResponseDto {
    private boolean ok;
    private ChatResult chat;
    private Long date;
    private String text;
}

@Data
class ChatResult{
    private Long id;
    private String title;
    private String type;
}
