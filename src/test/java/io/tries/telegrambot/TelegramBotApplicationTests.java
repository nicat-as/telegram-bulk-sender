package io.tries.telegrambot;

import io.tries.telegrambot.service.JsonParseService;
import io.tries.telegrambot.service.SendService;
import io.tries.telegrambot.service.TelegramService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Collectors;

@SpringBootTest
class TelegramBotApplicationTests {

    @Autowired
    TelegramService telegramService;
    @Autowired
    JsonParseService parseService;
    @Autowired
    SendService sendService;

    @Test
    void contextLoads() {
    }

    @Test
    void testSendMessage() {
        var res = telegramService.sendMessage("This is #microservice");
        System.out.println(res);
    }

    @Test
    void testJsonParsing() {
        var rs = parseService.getObject();
        var filteredCount = rs.getMessageItemList().stream()
                .filter(message -> message.getLink() == null || message.getLink().isEmpty())
                .collect(Collectors.toList());

        System.out.println("Count all: " + rs.getMessageItemList().size());
        System.out.println("Filtered count: " + filteredCount);
    }

    @Test
    void testSend() {
        sendService.sendMessage();
    }
}
