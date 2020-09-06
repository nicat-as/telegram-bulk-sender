package io.tries.telegrambot.service;

import io.tries.telegrambot.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class TelegramService {

    @Value("${telegram.url}")
    private String url;

    @Autowired
    private RestTemplate restTemplate;
    private AtomicInteger atomicInteger =new AtomicInteger(0);

    public ResponseDto sendMessage(String text) {
        ResponseDto responseDto = null;
        try {
            URI uri = UriComponentsBuilder.fromUriString(this.url).buildAndExpand(text).encode().toUri();
            System.out.println(atomicInteger.addAndGet(1) + ") " +uri);
            if (atomicInteger.get()%20==0){
                Thread.sleep(60 *1000);
            }
            responseDto = restTemplate.getForObject(uri, ResponseDto.class);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            return responseDto;
        }
    }
}
