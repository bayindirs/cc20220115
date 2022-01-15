package com.ccvisable.messaging.service

import com.ccvisable.messaging.data.FakeAccountRepository
import com.ccvisable.messaging.data.FakeMessagingRepository
import com.ccvisable.messaging.data.model.DbAccount
import com.ccvisable.messaging.exception.MessageSelfIsNotAllowed
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class MessagingServiceTest {
    private val accountRepository: FakeAccountRepository = FakeAccountRepository()
    private val messagingRepository: FakeMessagingRepository = FakeMessagingRepository()
    private val messagingService: MessagingService = MessagingService(
        accountRepository,
        messagingRepository
    )

    private val USER1: String = "user1"
    private val USER2: String = "user2"
    private val USER3: String = "user3"

    private val USER1_ID: String = "user1-id"
    private val USER2_ID: String = "user2-id"
    private val USER3_ID: String = "user3-id"

    @BeforeEach
    fun setupAll() {
        mapOf(USER1_ID to USER1, USER2_ID to USER2, USER3_ID to USER3).forEach {
            accountRepository.save(
                DbAccount(
                    it.key,
                    it.value
                )
            )
        }
    }

    @AfterEach
    fun cleanUp() {
        accountRepository.deleteAll()
        messagingRepository.deleteAll()
    }

    @Test
    fun shouldSaveMessage() {
        val text = "Hello from test"
        messagingService.saveMessage(USER1_ID, USER2_ID, text)
        val message = messagingRepository.findAll().firstOrNull()
        assertNotNull(message, "Message should be saved")
        assertEquals(USER1_ID, message?.from?.id, "From account should be set")
        assertEquals(USER2_ID, message?.to?.id, "To account should be set")
        assertEquals(text, message?.text, "Text should be set")
    }

    @Test
    fun shouldThrowExceptionWhenSendMessageSelf() {
        assertThrows<MessageSelfIsNotAllowed> {
            val text = "Hello from test"
            messagingService.saveMessage(USER1_ID, USER1_ID, text)
        }
    }

    @Test
    fun shouldReturnAllInbox() {
        messagingService.saveMessage(USER1_ID, USER2_ID, "text1")
        messagingService.saveMessage(USER1_ID, USER3_ID, "text2")
        val allIncoming = messagingService.getAllIncoming(USER2_ID)
        assertTrue(allIncoming.isNotEmpty(), "Should retrieve messages")
        assertTrue(allIncoming.all { it.to.contentEquals(USER2) }, "Messages should be filtered by to")
        assertTrue(allIncoming.all { it.from.isNotBlank() }, "From field should be set")
        assertTrue(allIncoming.all { it.to.isNotBlank() }, "To field should be set")
        assertTrue(allIncoming.all { it.text.isNotBlank() }, "Text field should be set")
    }

    @Test
    fun shouldFilterInbox() {
        messagingService.saveMessage(USER1_ID, USER2_ID, "text1")
        messagingService.saveMessage(USER3_ID, USER2_ID, "text2")
        val allIncoming = messagingService.getIncomingFrom(USER2_ID, USER1_ID)
        assertTrue(allIncoming.isNotEmpty(), "Should retrieve messages")
        assertTrue(allIncoming.all { it.to.contentEquals(USER2) }, "Messages should be filtered by to")
        assertTrue(allIncoming.all { it.from.contentEquals(USER1) }, "Messages should be filtered by from")
        assertTrue(allIncoming.all { it.from.isNotBlank() }, "From field should be set")
        assertTrue(allIncoming.all { it.to.isNotBlank() }, "To field should be set")
        assertTrue(allIncoming.all { it.text.isNotBlank() }, "Text field should be set")
    }

    @Test
    fun shouldReturnAllOutbox() {
        messagingService.saveMessage(USER1_ID, USER2_ID, "text1")
        messagingService.saveMessage(USER2_ID, USER3_ID, "text2")
        val allIncoming = messagingService.getAllOutgoing(USER1_ID)
        assertTrue(allIncoming.isNotEmpty(), "Should retrieve messages")
        assertTrue(allIncoming.all { it.from.contentEquals(USER1) }, "Messages should be filtered by to")
        assertTrue(allIncoming.all { it.from.isNotBlank() }, "From field should be set")
        assertTrue(allIncoming.all { it.to.isNotBlank() }, "To field should be set")
        assertTrue(allIncoming.all { it.text.isNotBlank() }, "Text field should be set")
    }
}