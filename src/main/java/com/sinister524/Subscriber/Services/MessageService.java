package com.sinister524.Subscriber.Services;

import com.sinister524.Subscriber.Entitys.Action;
import com.sinister524.Subscriber.Entitys.Message;
import com.sinister524.Subscriber.Entitys.Purchase;
import com.sinister524.Subscriber.Entitys.Subscription;
import com.sinister524.Subscriber.Repositories.PurchaseRepository;
import com.sinister524.Subscriber.Repositories.SubscriptionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class MessageService {

    private final Logger logger = LoggerFactory.getLogger(MessageService.class);

    @Autowired
    PurchaseRepository purchaseRepository;

    @Autowired
    SubscriptionRepository subscriptionRepository;

    public Message saveMessage (Message message) {
        logger.info("Saving message in DB." + message.toString());
        if (message.getAction() == Action.PURCHASE) {
            logger.info("Message save in PURCHASE table");
            return purchaseRepository.save(new Purchase(message.getMsisdn(),message.getTimeStamp()));

        } else {
            logger.info("Message save in SUBSCRIPTION table");
            return subscriptionRepository.save(new Subscription(message.getMsisdn(), message.getTimeStamp()));
        }
    }

    public List<Message> getMessages() {
        logger.info("Merging tables in Messages list and sending to PUBLISHER");
        return Stream.concat(
                purchaseRepository.findAll().stream()
                .map(purchase -> new Message(purchase.getMsisdn(), Action.PURCHASE, purchase.getTimestamp())),
                subscriptionRepository.findAll().stream()
                .map(subscription -> new Message(subscription.getMsisdn(), Action.SUBSCRIPTION, subscription.getTimestamp()))
        ).sorted(Comparator.comparing(Message::getTimeStamp).reversed())
                .collect(Collectors.toList());

    }
}
