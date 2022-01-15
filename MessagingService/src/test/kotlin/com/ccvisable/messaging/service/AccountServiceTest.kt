package com.ccvisable.messaging.service

import com.ccvisable.messaging.data.FakeAccountRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class AccountServiceTest {
    private val accountService = AccountService(
        FakeAccountRepository()
    )

    @Test
    fun createAccount() {
        val username = "test-user"
        accountService.createAccount(username)
        val retrieveAccountInfo = accountService.retrieveAccountInfo(username)
        assertEquals(username, retrieveAccountInfo.username, "username should be retrieved")
        assertTrue(retrieveAccountInfo.id.isNotBlank(), "id should not be blank")
    }
}