package com.accolite.kafka;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service("Producer")
public class Producer {
    private static final String KAFKA_TOPIC = "BeforePass";
    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public void sendMessage(String message){
        this.kafkaTemplate.send(KAFKA_TOPIC,message);
    }
    @Bean
    public NewTopic createTopic(){

        return new NewTopic(KAFKA_TOPIC,3,(short) 1);
    }
}
