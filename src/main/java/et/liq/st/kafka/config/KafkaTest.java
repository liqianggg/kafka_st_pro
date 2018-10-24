package et.liq.st.kafka.config;

public class KafkaTest {
    public static void main(String[] args) {
//       KafkaProducerConfig<String,String> kafkaConfig = new KafkaProducerConfig<>();
//       kafkaConfig.sendMessage("my-config-topic","topicName","my-config-topic");
        KafkaConsumerConfig<String, String> kafkaConsumer = new KafkaConsumerConfig<String, String>();
        kafkaConsumer.getMessage("my-config-topic");
    }

}
