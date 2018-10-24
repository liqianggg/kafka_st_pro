package et.liq.st.kafka.config;

public class KafkaTest {
    public static void main(String[] args) {
        //kafka 发布消息
        KafkaProducerConfig<String, String> kafkaConfig = new KafkaProducerConfig<>();
        kafkaConfig.sendMessage("my-config-topic", "topicName", "my-config-topic");
        // consumer 订阅消息
        KafkaConsumerConfig<String, String> kafkaConsumer = new KafkaConsumerConfig<String, String>();
        kafkaConsumer.getMessage("my-config-topic");
    }

}
