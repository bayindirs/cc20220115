package com.ccvisable.messaging.service

import com.ccvisable.messaging.api.model.PostInfo
import com.ccvisable.messaging.data.AccountRepository
import com.ccvisable.messaging.data.MessageRepository
import com.ccvisable.messaging.data.model.DbMessage
import com.ccvisable.messaging.exception.MessageSelfIsNotAllowed
import com.ccvisable.messaging.exception.UserNotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class MessagingService(
    private val accountRepository: AccountRepository,
    private val messageRepository: MessageRepository
) {

    /**
     * from: account-id of the sender
     * to: account-id of the receiver
     */
    fun saveMessage(from: String, to: String, text: String) {
        if (from.contentEquals(to)) {
            throw MessageSelfIsNotAllowed()
        }
        val fromAccount = accountRepository.findByIdOrNull(from)
            ?: throw UserNotFoundException()
        val toAccount = accountRepository.findByIdOrNull(to)
            ?: throw UserNotFoundException()
        messageRepository.save(
            DbMessage(
                from = fromAccount,
                to = toAccount,
                text = text
            )
        )
    }

    fun getAllIncoming(accountId: String): List<PostInfo> {
        return messageRepository.findByTo_Id(accountId)
            .map(this::mapPostInfo)
            .toCollection(mutableListOf())
    }

    fun getAllOutgoing(accountId: String): List<PostInfo> {
        return messageRepository.findByFrom_Id(accountId)
            .map(this::mapPostInfo)
            .toCollection(mutableListOf())
    }

    fun getIncomingFrom(accountId: String, fromAccountId: String): List<PostInfo> {
        return messageRepository.findByTo_IdAndFrom_Id(accountId, fromAccountId)
            .map(this::mapPostInfo)
            .toCollection(mutableListOf())
    }

    private fun mapPostInfo(it: DbMessage) = PostInfo(
        it.from!!.username,
        it.to!!.username,
        it.text
    )
}