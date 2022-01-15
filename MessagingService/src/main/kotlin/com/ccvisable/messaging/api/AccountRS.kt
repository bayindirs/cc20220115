package com.ccvisable.messaging.api

import com.ccvisable.messaging.api.exception.UserNotFoundException
import com.ccvisable.messaging.api.model.AccountInfo
import com.ccvisable.messaging.api.model.AccountRegisterInfo
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/account")
class AccountRS {

    @PostMapping
    fun createAccount(@RequestBody accountRegisterInfo: AccountRegisterInfo) {

    }

    @GetMapping("/{username}")
    fun getAccount(@PathVariable username: String): AccountInfo {
        throw UserNotFoundException()
    }
}