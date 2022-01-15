package com.ccvisable.messaging.data

import com.ccvisable.messaging.data.model.DbAccount
import org.springframework.data.jpa.repository.JpaRepository

interface AccountRepository : JpaRepository<DbAccount, String> {

    fun findByUsername(username: String): DbAccount?

}
