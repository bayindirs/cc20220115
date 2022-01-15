package com.ccvisable.messaging.config

import org.apache.kafka.clients.admin.NewTopic
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.DefaultKafkaProducerFactory
import org.springframework.kafka.core.KafkaTemplate

@Configuration
class KafkaTopicConfig {
    companion object {
        const val NEW_POST_TOPIC = "topic-new-post"
        const val GROUP_ID = "group-messaging-app"
    }

    @Value("#{environment.KAFKA_BOOTSTRAP_ADDRESS}")
    var bootstrapAddress: String = ""

    @Bean
    fun newPostTopic() = NewTopic(NEW_POST_TOPIC, 1, 1)

    @Bean
    fun kafkaProducerFactory() = DefaultKafkaProducerFactory<String, String>(
        mapOf(
            ProducerConfig.BOOTSTRAP_SERVERS_CONFIG to bootstrapAddress,
            ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG to StringSerializer::class.java,
            ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG to StringSerializer::class.java
        )
    )

    @Bean
    fun kafkaTemplate(kafkaProducerFactory: DefaultKafkaProducerFactory<String, String>) =
        KafkaTemplate(kafkaProducerFactory)
}