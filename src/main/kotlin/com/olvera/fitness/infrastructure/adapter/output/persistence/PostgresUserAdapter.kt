package com.olvera.fitness.infrastructure.adapter.output.persistence

import com.olvera.fitness.domain.model.User
import com.olvera.fitness.domain.outbound.UserRepositoryPort
import com.olvera.fitness.infrastructure.adapter.output.persistence.mapper.toDomain
import com.olvera.fitness.infrastructure.adapter.output.persistence.mapper.toJpaEntity
import com.olvera.fitness.infrastructure.adapter.output.persistence.repository.SpringDataJpaUserRepository
import org.springframework.stereotype.Component

@Component
class PostgresUserAdapter(
    private val jpaRepository: SpringDataJpaUserRepository
): UserRepositoryPort {

    override fun save(user: User): User {
        val entity = user.toJpaEntity()
        return jpaRepository.save(entity).toDomain()
    }
}