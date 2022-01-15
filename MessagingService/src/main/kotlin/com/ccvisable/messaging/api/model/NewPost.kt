package com.ccvisable.messaging.api.model

data class NewPost(
    /**
     * account-id of the sender
     */
    var from: String = "",

    /**
     * account-id of the receiver
     */
    var to: String = "",
    var text: String = ""
)
