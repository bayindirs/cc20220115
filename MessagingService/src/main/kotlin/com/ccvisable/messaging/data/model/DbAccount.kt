package com.ccvisable.messaging.data.model

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class DbAccount(
    @Id
    @Column
    var id: String = UUID.randomUUID().toString(),
    @Column
    var username: String = ""
)
