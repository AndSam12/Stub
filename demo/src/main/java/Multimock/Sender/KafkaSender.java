package Multimock.Sender;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component

public class KafkaSender {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String topicName, String message) {
        System.out.println("Producer. topic <"+topicName+">"+": "+message);
        kafkaTemplate.send(topicName, message);
    }
}
