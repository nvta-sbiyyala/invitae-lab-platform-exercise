package com.invitae.lab.platform.repository

import com.invitae.lab.platform.domain.Variant
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
@Transactional
interface VariantRepository: JpaRepository<Variant, Long>
