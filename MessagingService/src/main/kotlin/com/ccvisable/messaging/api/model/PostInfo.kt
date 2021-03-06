package com.ccvisable.messaging.api.model

data class PostInfo(

    /**
     * username of the sender
     */
    var from: String = "",

    /**
     * username of the receiver
     */
    var to: String = "",

    var text: String = ""
)
