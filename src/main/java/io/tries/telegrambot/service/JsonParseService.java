package io.tries.telegrambot.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.tries.telegrambot.dto.MessageList;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Arrays;
import java.util.List;

@Service
public class JsonParseService {
    private final String json = "parsed.json";

    @SneakyThrows
    public MessageList getObject() {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(json), MessageList.class);
    }
}
