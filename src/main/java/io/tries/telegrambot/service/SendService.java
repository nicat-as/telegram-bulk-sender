package io.tries.telegrambot.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SendService {
    @Autowired
    private JsonParseService jsonParseService;
    @Autowired
    private TelegramService telegramService;

    public void sendMessage() {
        var parsed = jsonParseService.getObject();
        parsed.getMessageItemList()
                .stream()
                .filter(message -> message.getLink() != null && !message.getLink().isEmpty())
                .forEach(message -> {
                    StringBuilder builder = new StringBuilder();
                    builder.append(message.getLink()).append("\n");
                    message.getTags().stream()
                            .forEach(s -> builder.append(s).append(" "));
                    System.out.println(builder.toString());
                    var rs = telegramService.sendMessage(builder.toString());
                    System.out.println(rs);
                });

    }
}
