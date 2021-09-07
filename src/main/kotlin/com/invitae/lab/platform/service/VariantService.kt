package com.invitae.lab.platform.service

import com.invitae.lab.platform.domain.Variant
import com.invitae.lab.platform.repository.VariantRepository
import org.springframework.context.annotation.ComponentScan
import org.springframework.stereotype.Service

@Service
@ComponentScan
class VariantService(val variantRepository: VariantRepository) {
    fun createVariant(variant: Variant) {
        variantRepository.save(variant)
    }
}