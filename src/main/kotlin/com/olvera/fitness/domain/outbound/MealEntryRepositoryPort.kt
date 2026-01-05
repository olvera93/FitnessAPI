package com.olvera.fitness.domain.outbound

import com.olvera.fitness.domain.model.MealEntry
import com.olvera.fitness.domain.model.MealEntryId
import com.olvera.fitness.domain.model.UserId
import java.time.LocalDate
import java.util.UUID

interface MealEntryRepositoryPort {

    suspend fun save(mealEntry: MealEntry): MealEntry

    suspend fun findByUserAndDateRange(userId: UUID, startDate: LocalDate, endDate: LocalDate): List<MealEntry>

    suspend fun deleteById(id: MealEntryId)

}