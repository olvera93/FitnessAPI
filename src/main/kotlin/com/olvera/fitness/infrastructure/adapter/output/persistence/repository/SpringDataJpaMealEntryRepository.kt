package com.olvera.fitness.infrastructure.adapter.output.persistence.repository

import com.olvera.fitness.domain.model.MealEntry
import com.olvera.fitness.infrastructure.adapter.output.persistence.entity.MealEntryJpaEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.time.LocalDateTime
import java.util.UUID

@Repository
interface SpringDataJpaMealEntryRepository : JpaRepository<MealEntryJpaEntity, UUID> {

    fun findAllByUserIdAndEntryTimeBetweenOrderByEntryTimeDesc(
        userId: UUID,
        startDate: LocalDateTime,
        endDate: LocalDateTime
    ): List<MealEntryJpaEntity>
}