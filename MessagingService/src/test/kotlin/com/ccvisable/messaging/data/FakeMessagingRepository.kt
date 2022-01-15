package com.ccvisable.messaging.data

import com.ccvisable.messaging.data.model.DbMessage
import org.springframework.data.domain.Example
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.repository.query.FluentQuery
import java.util.*
import java.util.function.Function

class FakeMessagingRepository : MessageRepository {

    private val messages: MutableList<DbMessage> = mutableListOf()

    override fun findByTo_Id(accountId: String): List<DbMessage> {
        return messages.filter { it.to!!.id.contentEquals(accountId) }
    }

    override fun findByTo_IdAndFrom_Id(toId: String, fromId: String): List<DbMessage> {
        return messages.filter {
            it.to!!.id.contentEquals(toId) &&
                    it.from!!.id.contentEquals(fromId)
        }
    }

    override fun findByFrom_Id(accountId: String): List<DbMessage> {
        return messages.filter { it.from!!.id.contentEquals(accountId) }
    }

    override fun <S : DbMessage?> save(entity: S): S {
        if (entity != null) {
            messages.add(entity)
        }
        return entity
    }

    override fun <S : DbMessage?> saveAll(entities: MutableIterable<S>): MutableList<S> {
        TODO("Not yet implemented")
    }

    override fun findById(id: String): Optional<DbMessage> {
        TODO("Not yet implemented")
    }

    override fun existsById(id: String): Boolean {
        TODO("Not yet implemented")
    }

    override fun findAll(): MutableList<DbMessage> {
        return messages.toMutableList()
    }

    override fun findAll(sort: Sort): MutableList<DbMessage> {
        TODO("Not yet implemented")
    }

    override fun <S : DbMessage?> findAll(example: Example<S>): MutableList<S> {
        TODO("Not yet implemented")
    }

    override fun <S : DbMessage?> findAll(example: Example<S>, sort: Sort): MutableList<S> {
        TODO("Not yet implemented")
    }

    override fun findAll(pageable: Pageable): Page<DbMessage> {
        TODO("Not yet implemented")
    }

    override fun <S : DbMessage?> findAll(example: Example<S>, pageable: Pageable): Page<S> {
        TODO("Not yet implemented")
    }

    override fun findAllById(ids: MutableIterable<String>): MutableList<DbMessage> {
        TODO("Not yet implemented")
    }

    override fun count(): Long {
        TODO("Not yet implemented")
    }

    override fun <S : DbMessage?> count(example: Example<S>): Long {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: String) {
        TODO("Not yet implemented")
    }

    override fun delete(entity: DbMessage) {
        TODO("Not yet implemented")
    }

    override fun deleteAllById(ids: MutableIterable<String>) {
        TODO("Not yet implemented")
    }

    override fun deleteAll(entities: MutableIterable<DbMessage>) {
        TODO("Not yet implemented")
    }

    override fun deleteAll() {
        messages.clear()
    }

    override fun <S : DbMessage?> findOne(example: Example<S>): Optional<S> {
        TODO("Not yet implemented")
    }

    override fun <S : DbMessage?> exists(example: Example<S>): Boolean {
        TODO("Not yet implemented")
    }

    override fun <S : DbMessage?, R : Any?> findBy(
        example: Example<S>,
        queryFunction: Function<FluentQuery.FetchableFluentQuery<S>, R>
    ): R {
        TODO("Not yet implemented")
    }

    override fun flush() {
        TODO("Not yet implemented")
    }

    override fun <S : DbMessage?> saveAndFlush(entity: S): S {
        TODO("Not yet implemented")
    }

    override fun <S : DbMessage?> saveAllAndFlush(entities: MutableIterable<S>): MutableList<S> {
        TODO("Not yet implemented")
    }

    override fun deleteAllInBatch(entities: MutableIterable<DbMessage>) {
        TODO("Not yet implemented")
    }

    override fun deleteAllInBatch() {
        TODO("Not yet implemented")
    }

    override fun deleteAllByIdInBatch(ids: MutableIterable<String>) {
        TODO("Not yet implemented")
    }

    override fun getOne(id: String): DbMessage {
        TODO("Not yet implemented")
    }

    override fun getById(id: String): DbMessage {
        TODO("Not yet implemented")
    }

}
