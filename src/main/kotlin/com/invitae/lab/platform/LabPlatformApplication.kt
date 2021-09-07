package com.invitae.lab.platform

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@ComponentScan(basePackages = arrayOf("com.invitae.lab.platform"))
@EnableJpaRepositories(basePackages = arrayOf("com.invitae.lab.platform.repository"))
@EntityScan(value = arrayOf("com.invitae.lab.platform.domain"))
class LabPlatformApplication

fun main(args: Array<String>) {
	runApplication<LabPlatformApplication>(*args)
}
