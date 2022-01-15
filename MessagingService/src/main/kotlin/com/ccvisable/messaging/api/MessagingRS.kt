package com.ccvisable.messaging.api

import com.ccvisable.messaging.api.model.Inbox
import com.ccvisable.messaging.api.model.NewPost
import com.ccvisable.messaging.api.model.Outbox
import com.ccvisable.messaging.api.model.PostInfo
import com.ccvisable.messaging.kafka.KafkaSender
import com.ccvisable.messaging.service.MessagingService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/messaging")
class MessagingRS(
    private val messagingService: MessagingService,
    private val kafkaSender: KafkaSender
) {

    @PostMapping("/send")
    fun send(@RequestBody newPost: NewPost) {
        kafkaSender.sendNewMessage(newPost)
    }

    @GetMapping("{accountId}/inbox")
    fun inbox(@PathVariable accountId: String, @RequestParam from: String?): Inbox {
        val posts: List<PostInfo>
        if (from.isNullOrBlank()) {
            posts = messagingService.getAllIncoming(accountId)
        } else {
            posts = messagingService.getIncomingFrom(accountId, from)
        }
        return Inbox(posts)
    }

    @GetMapping("{accountId}/outbox")
    fun outbox(@PathVariable accountId: String): Outbox {
        return Outbox(messagingService.getAllOutgoing(accountId))
    }
}