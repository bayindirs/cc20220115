package com.ccvisable.messaging.config

import org.apache.kafka.clients.admin.AdminClientConfig
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.KafkaAdmin

@Configuration
class KafkaConfig {

    @Value("#{environment.KAFKA_BOOTSTRAP_ADDRESS}")
    var bootstrapAddress: String = ""

    @Bean
    fun kafkaAdmin() = KafkaAdmin(
        mapOf(
            AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG to bootstrapAddress
        )
    )

}