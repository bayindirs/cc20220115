package com.ccvisable.messaging.kafka

import com.ccvisable.messaging.api.model.NewPost
import com.ccvisable.messaging.config.KafkaTopicConfig
import com.google.gson.Gson
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class KafkaSender(
    private val kafkaTemplate: KafkaTemplate<String, String>
) {
    fun sendNewMessage(newPost: NewPost) {
        kafkaTemplate.send(KafkaTopicConfig.NEW_POST_TOPIC, Gson().toJson(newPost))
    }
}