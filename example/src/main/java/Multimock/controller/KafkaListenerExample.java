package Multimock.controller;



import Multimock.model.Item;
import Multimock.repository.ItemService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component

public class KafkaListenerExample {
    Gson g = new Gson();
    final String TOPIC_1 = "Game";
    final String TOPIC_2 = "Film";
    final String GROUPID = "group1";

    @Autowired
    private ItemService itemService;

    private void listenAndSend2Redis (String data){
        Item item = g.fromJson(data, Item.class);
        itemService.saveItem(item);
        System.out.println("Redis: Item "  + item.getName() + " sent to Redis");
    }

    @KafkaListener(topics = TOPIC_1, groupId = GROUPID)
    void listenerTopic1(String data) {
        System.out.println("Consumer. Topic + " + TOPIC_1 + ". New message: " + data);
        listenAndSend2Redis(data);
    }
    @KafkaListener(topics = TOPIC_2, groupId = GROUPID)
    void listenerTopic2(String data) {
        System.out.println("Consumer. Topic + " + TOPIC_2 + ". New message: " + data);
        listenAndSend2Redis(data);
    }
}
