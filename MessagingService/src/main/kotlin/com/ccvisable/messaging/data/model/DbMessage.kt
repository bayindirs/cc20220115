package com.ccvisable.messaging.data.model

import java.util.*
import javax.persistence.*

@Entity
class DbMessage(
    @Id
    @Column
    var id: String = UUID.randomUUID().toString(),

    @JoinColumn(nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    var from: DbAccount? = null,

    @JoinColumn(nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    var to: DbAccount? = null,

    @Column
    var text: String = ""
)
