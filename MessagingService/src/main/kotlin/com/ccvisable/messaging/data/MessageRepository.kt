package com.ccvisable.messaging.data

import com.ccvisable.messaging.data.model.DbMessage
import org.springframework.data.jpa.repository.JpaRepository

interface MessageRepository : JpaRepository<DbMessage, String> {

    fun findByTo_Id(accountId: String): List<DbMessage>
    fun findByTo_IdAndFrom_Id(toId: String, fromId: String): List<DbMessage>
    fun findByFrom_Id(accountId: String): List<DbMessage>

}
