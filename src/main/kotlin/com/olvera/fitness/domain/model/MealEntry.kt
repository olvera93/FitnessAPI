package com.olvera.fitness.domain.model

import java.time.LocalDateTime
import java.util.UUID

@JvmInline
value class MealEntryId(val value: UUID)

data class MealEntry(
    val id: MealEntryId = MealEntryId(UUID.randomUUID()),
    val userId: UserId,
    val entryTime: LocalDateTime,
    val name: String,

    val totalCalories: Int,
    val proteinGrams: Int,
    val fatGrams: Int,
    val carbGrams: Int,

    val imageUrl: String?

    )
