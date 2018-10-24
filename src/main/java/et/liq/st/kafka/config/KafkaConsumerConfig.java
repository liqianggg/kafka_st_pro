package et.liq.st.kafka.config;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.context.annotation.Configuration;

import javax.sound.midi.Soundbank;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

public class KafkaConsumerConfig<K,V> {

    private KafkaConsumer<K,V> kafkaConsumer;

    public KafkaConsumerConfig() {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("group.id", "test");
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        this.kafkaConsumer = new KafkaConsumer<K, V>(props);
    }

    /**
     *
     * @param topic 消息主题
     */
    public void getMessage(String...topic){
       kafkaConsumer.subscribe(Arrays.asList(topic));
           ConsumerRecords<K,V> records = kafkaConsumer.poll(Duration.ofSeconds(1));
           for (ConsumerRecord<K,V> record:records){
               System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
           }
    }

}
