package com.olvera.fitness.domain.model

import java.math.BigDecimal
import java.time.LocalDate
import java.util.UUID


@JvmInline
value class MetricId(val value: UUID)

data class UserMetric(
    val id: MetricId = MetricId(UUID.randomUUID()),
    val userId: UserId,
    val measurementDate: LocalDate,
    val weightKg: BigDecimal,
    val bodyFatPercentage: BigDecimal? = null,
    val waistCircumferenceCm: BigDecimal? = null,
    val notes: String?
)
