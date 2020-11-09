package com.sinister524.Subscriber.Controllers;

import com.sinister524.Subscriber.Entitys.Message;
import com.sinister524.Subscriber.Services.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MessageController {
    private final Logger logger = LoggerFactory.getLogger(MessageController.class);

    @Autowired
    MessageService messageService;

    @GetMapping
    public List<Message> getMessages () {
        logger.info("Take GET request from PUBLISHER");
        return messageService.getMessages();
    }

    @PostMapping
    public void saveMessage(@RequestBody Message message) {
        logger.info("Take POST request from PUBLISHER");
        messageService.saveMessage(message);
    }
}
