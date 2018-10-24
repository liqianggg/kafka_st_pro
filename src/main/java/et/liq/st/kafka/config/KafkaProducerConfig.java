package et.liq.st.kafka.config;

import org.apache.kafka.clients.producer.*;

import java.util.Properties;

public class KafkaProducerConfig<K,V> {

    private Producer<K,V> kafkaProducer;

    public KafkaProducerConfig() {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        this.kafkaProducer = new KafkaProducer<K, V>(props);
    }

    /**
     *
     * @param topicName 消息发布主题名称
     * @param k key
     * @param v 消息内容
     */
    public void sendMessage(String topicName,K k,V v){
        ProducerRecord<K,V> producerRecord = new ProducerRecord(topicName,k,v);
        kafkaProducer.send(producerRecord, (metadata, exception) -> {
            if (exception!=null)
                exception.printStackTrace();
            System.out.println("the offset of the record we just snt is:"+metadata.offset());//消息偏移量
        });
        kafkaProducer.close();
    }

}
