package com.ccvisable.messaging.kafka

import com.ccvisable.messaging.api.model.NewPost
import com.ccvisable.messaging.config.KafkaTopicConfig
import com.ccvisable.messaging.exception.BusinessException
import com.ccvisable.messaging.service.MessagingService
import com.google.gson.Gson
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service


@Service
class NewMessageKafkaListener(private val messagingService: MessagingService) {

    @KafkaListener(topics = [KafkaTopicConfig.NEW_POST_TOPIC], groupId = KafkaTopicConfig.GROUP_ID)
    fun listNewPostTopic(newPostJson: String) {
        val newPost = Gson().fromJson(newPostJson, NewPost::class.java)
        try {
            messagingService.saveMessage(
                newPost.from,
                newPost.to,
                newPost.text
            )
        } catch (e: BusinessException) {
            e.printStackTrace()
        }
    }

}
