import kr.entree.spigradle.kotlin.*
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
    id("kr.entree.spigradle")
    id("com.github.johnrengelman.shadow")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    jcenter()
    // PaperMC Repository
    papermc()
}

val minecraft_version: String by project

dependencies {
    // PaperMC Dependency
    compileOnly(paper(minecraft_version))

    // Add your dependencies here
    // Examples
    // implementation("io.ktor", "ktor-client", "1.4.0") // Would be shaded into the final jar
    // compileOnly("io.ktor", "ktor-client", "1.4.0") // Only used on compile time
}

// This is your plugin.yml
spigot {
    name = "ExamplePlugin"
    authors = listOf("Me")
    apiVersion = "1.16"
    commands {
        // Example command
        create("example") {
            description = "Example command"
            permission = "example.permission"
            aliases = emptyList()
        }
    }
}

tasks {
    jar {
        // Disabled, because we use the shadowJar task for building our jar
        enabled = false
    }
    build {
        dependsOn(shadowJar)
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "1.8"
    }
}
