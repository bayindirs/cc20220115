package com.ccvisable.messaging.data

import com.ccvisable.messaging.data.model.DbAccount
import org.springframework.data.domain.Example
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.repository.query.FluentQuery
import java.util.*
import java.util.function.Function

class FakeAccountRepository : AccountRepository {

    private val accounts: MutableList<DbAccount> = mutableListOf()

    override fun findByUsername(username: String): DbAccount? {
        return accounts.firstOrNull { it.username.contentEquals(username) }
    }

    override fun <S : DbAccount?> save(entity: S): S {
        if (entity != null) {
            accounts.add(entity)
        }
        return entity
    }

    override fun <S : DbAccount?> saveAll(entities: MutableIterable<S>): MutableList<S> {
        TODO("Not yet implemented")
    }

    override fun findById(id: String): Optional<DbAccount> {
        TODO("Not yet implemented")
    }

    override fun existsById(id: String): Boolean {
        TODO("Not yet implemented")
    }

    override fun findAll(): MutableList<DbAccount> {
        TODO("Not yet implemented")
    }

    override fun findAll(sort: Sort): MutableList<DbAccount> {
        TODO("Not yet implemented")
    }

    override fun <S : DbAccount?> findAll(example: Example<S>): MutableList<S> {
        TODO("Not yet implemented")
    }

    override fun <S : DbAccount?> findAll(example: Example<S>, sort: Sort): MutableList<S> {
        TODO("Not yet implemented")
    }

    override fun findAll(pageable: Pageable): Page<DbAccount> {
        TODO("Not yet implemented")
    }

    override fun <S : DbAccount?> findAll(example: Example<S>, pageable: Pageable): Page<S> {
        TODO("Not yet implemented")
    }

    override fun findAllById(ids: MutableIterable<String>): MutableList<DbAccount> {
        TODO("Not yet implemented")
    }

    override fun count(): Long {
        TODO("Not yet implemented")
    }

    override fun <S : DbAccount?> count(example: Example<S>): Long {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: String) {
        TODO("Not yet implemented")
    }

    override fun delete(entity: DbAccount) {
        TODO("Not yet implemented")
    }

    override fun deleteAllById(ids: MutableIterable<String>) {
        TODO("Not yet implemented")
    }

    override fun deleteAll(entities: MutableIterable<DbAccount>) {
        TODO("Not yet implemented")
    }

    override fun deleteAll() {
        TODO("Not yet implemented")
    }

    override fun <S : DbAccount?> findOne(example: Example<S>): Optional<S> {
        TODO("Not yet implemented")
    }

    override fun <S : DbAccount?> exists(example: Example<S>): Boolean {
        TODO("Not yet implemented")
    }

    override fun <S : DbAccount?, R : Any?> findBy(
        example: Example<S>,
        queryFunction: Function<FluentQuery.FetchableFluentQuery<S>, R>
    ): R {
        TODO("Not yet implemented")
    }

    override fun flush() {
        TODO("Not yet implemented")
    }

    override fun <S : DbAccount?> saveAndFlush(entity: S): S {
        TODO("Not yet implemented")
    }

    override fun <S : DbAccount?> saveAllAndFlush(entities: MutableIterable<S>): MutableList<S> {
        TODO("Not yet implemented")
    }

    override fun deleteAllInBatch(entities: MutableIterable<DbAccount>) {
        TODO("Not yet implemented")
    }

    override fun deleteAllInBatch() {
        TODO("Not yet implemented")
    }

    override fun deleteAllByIdInBatch(ids: MutableIterable<String>) {
        TODO("Not yet implemented")
    }

    override fun getOne(id: String): DbAccount {
        TODO("Not yet implemented")
    }

    override fun getById(id: String): DbAccount {
        TODO("Not yet implemented")
    }

}
