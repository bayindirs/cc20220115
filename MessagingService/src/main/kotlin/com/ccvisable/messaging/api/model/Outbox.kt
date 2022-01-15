package com.ccvisable.messaging.api.model

data class Outbox(val posts: List<PostInfo>)
