import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	id("org.flywaydb.flyway") version "7.14.1"
	id("org.springframework.boot") version "2.6.0-SNAPSHOT"
	kotlin("jvm") version "1.5.21"
	kotlin("plugin.jpa") version "1.5.21"
	kotlin("plugin.spring") version "1.5.21"
}

group = "com.invitae"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
	mavenCentral()
	maven { url = uri("https://repo.spring.io/milestone") }
	maven { url = uri("https://repo.spring.io/snapshot") }
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-webflux:2.5.4")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.12.5")
	implementation("io.projectreactor.kotlin:reactor-kotlin-extensions:1.1.4")
	implementation("javax.persistence:javax.persistence-api:2.2")
	implementation("javax.transaction:javax.transaction-api:1.3")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor:1.5.1-native-mt")
	implementation("org.postgresql:postgresql:42.2.23")
	implementation("org.springframework.boot:spring-boot-starter-actuator:2.5.4")
	implementation("org.springframework.data:spring-data-jpa:2.5.4")
	implementation("org.springframework:spring-beans:5.3.9")
	testImplementation("org.assertj:assertj-core:3.20.2")
	testImplementation("org.springframework.boot:spring-boot-starter-test:2.5.4")
	testImplementation("io.mockk:mockk:1.12.0")
	testImplementation("io.mockk:mockk-common:1.12.0")
	testImplementation("io.projectreactor:reactor-test:3.4.9")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
