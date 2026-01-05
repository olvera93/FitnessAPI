package com.olvera.fitness.infrastructure.adapter.output.persistence

import com.olvera.fitness.domain.model.MealEntry
import com.olvera.fitness.domain.model.MealEntryId
import com.olvera.fitness.domain.outbound.MealEntryRepositoryPort
import com.olvera.fitness.infrastructure.adapter.output.persistence.mapper.toDomain
import com.olvera.fitness.infrastructure.adapter.output.persistence.mapper.toJpaEntity
import com.olvera.fitness.infrastructure.adapter.output.persistence.repository.SpringDataJpaMealEntryRepository
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext
import org.springframework.stereotype.Component
import java.time.LocalDate
import java.time.LocalTime
import java.util.UUID

@Component
class PostgresMealEntryAdapter(
    private val jpaRepository: SpringDataJpaMealEntryRepository
) : MealEntryRepositoryPort {

    override suspend fun save(mealEntry: MealEntry): MealEntry = withContext(IO) {
        val entity = mealEntry.toJpaEntity()
        jpaRepository.save(entity).toDomain()
    }

    override suspend fun findByUserAndDateRange(
        userId: UUID,
        startDate: LocalDate,
        endDate: LocalDate
    ): List<MealEntry> = withContext(IO) {

        val startDateTime = startDate.atStartOfDay()
        val endDateTime = endDate.atTime(LocalTime.MAX)

        jpaRepository.findAllByUserIdAndEntryTimeBetweenOrderByEntryTimeDesc(
            userId = userId,
            startDate = startDateTime,
            endDate = endDateTime
        ).map { it.toDomain() }

    }

    override suspend fun deleteById(id: MealEntryId) = withContext(IO) {
        jpaRepository.deleteById(id.value)
    }

}