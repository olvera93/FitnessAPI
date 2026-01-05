package com.olvera.fitness.infrastructure.adapter.output.persistence.mapper

import com.olvera.fitness.domain.model.MealEntry
import com.olvera.fitness.domain.model.MealEntryId
import com.olvera.fitness.domain.model.UserId
import com.olvera.fitness.infrastructure.adapter.output.persistence.entity.MealEntryJpaEntity

fun MealEntryJpaEntity.toDomain(): MealEntry {
    return MealEntry(
        id = MealEntryId(this.id),
        userId = UserId(this.userId),
        entryTime = this.entryTime,
        name = this.name,
        totalCalories = this.totalCalories,
        proteinGrams = this.proteinGrams,
        fatGrams = this.fatGrams,
        carbGrams = this.carbGrams,
        imageUrl = this.imageUrl,
    )
}

fun MealEntry.toJpaEntity(): MealEntryJpaEntity {
    return MealEntryJpaEntity(
        id = this.id.value,
        userId = this.userId.value,
        entryTime = this.entryTime,
        name = this.name,
        totalCalories = this.totalCalories,
        proteinGrams = this.proteinGrams,
        fatGrams = this.fatGrams,
        carbGrams = this.carbGrams,
        imageUrl = this.imageUrl
    )
}