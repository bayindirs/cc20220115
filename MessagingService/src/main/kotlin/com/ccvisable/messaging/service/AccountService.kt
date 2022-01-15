package com.ccvisable.messaging.service

import com.ccvisable.messaging.api.model.AccountInfo
import com.ccvisable.messaging.data.AccountRepository
import com.ccvisable.messaging.data.model.DbAccount
import com.ccvisable.messaging.exception.UserAlreadyExistException
import com.ccvisable.messaging.exception.UserNotFoundException
import org.springframework.stereotype.Service

@Service
class AccountService(
    private val accountRepository: AccountRepository
) {

    fun createAccount(username: String) {
        if (accountRepository.findByUsername(username) != null) {
            throw UserAlreadyExistException()
        }
        accountRepository.save(DbAccount(username = username))
    }

    fun retrieveAccountInfo(username: String): AccountInfo {
        return with(accountRepository.findByUsername(username)) {
            if (this == null) {
                throw UserNotFoundException()
            }
            AccountInfo(this.id, this.username)
        }
    }
}