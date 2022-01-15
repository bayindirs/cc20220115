package com.ccvisable.messaging.api

import com.ccvisable.messaging.api.model.Inbox
import com.ccvisable.messaging.api.model.Outbox
import com.ccvisable.messaging.api.model.PostInfo
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/messaging")
class MessagingRS {

    @PostMapping("/send")
    fun send(@RequestBody postInfo: PostInfo) {

    }

    @GetMapping("{userId}/inbox")
    fun inbox(@PathVariable userId: String, @RequestParam from: String?): Inbox {
        return Inbox(Collections.emptyList())
    }

    @GetMapping("{userId}/outbox")
    fun outbox(@PathVariable userId: String): Outbox {
        return Outbox(Collections.emptyList())
    }
}