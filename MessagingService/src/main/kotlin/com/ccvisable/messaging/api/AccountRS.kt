package com.ccvisable.messaging.api

import com.ccvisable.messaging.api.model.AccountInfo
import com.ccvisable.messaging.api.model.AccountRegisterInfo
import com.ccvisable.messaging.service.AccountService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/account")
class AccountRS(val accountService: AccountService) {

    @PostMapping
    fun createAccount(@RequestBody accountRegisterInfo: AccountRegisterInfo) {
        accountService.createAccount(accountRegisterInfo.username)
    }

    @GetMapping("/{username}")
    fun getAccount(@PathVariable username: String): AccountInfo {
        return accountService.retrieveAccountInfo(username)
    }
}