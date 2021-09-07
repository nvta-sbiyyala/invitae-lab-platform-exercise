package com.invitae.lab.platform.controller

import com.invitae.lab.platform.domain.Variant
import com.invitae.lab.platform.service.VariantService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/variant")
class VariantController(val variantService: VariantService) {
    @PostMapping
    fun createVariant(@RequestBody variant: Variant) {
        variantService.createVariant(variant)
    }

    @GetMapping("/info")
    fun sayHello(): String {
        return "Invitae Gene Variant Service v1"
    }
}