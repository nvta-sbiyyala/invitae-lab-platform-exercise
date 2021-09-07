package com.invitae.lab.platform.domain

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDateTime
import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Table(name = "gene.variant")
@Entity
data class Variant(
    @Column(name = "gene", nullable = false, updatable = false)
    val gene: String,

    @Column(name = "nucleotideChange", nullable = false)
    val nucleotideChange: String,

    @Column(name = "proteinChange", nullable = false)
    val proteinChange: String,
) {
    val id: UUID

    @JsonFormat(pattern = "yyyy-MM-dd")
    val lastEvaluated: LocalDateTime

    init {
        @Id
        @Column(name = "id", nullable = false, updatable = false)
        id = UUID.randomUUID()

        @Column(name = "lastEvaluated", nullable = false)
        lastEvaluated = LocalDateTime.now()
    }
}
