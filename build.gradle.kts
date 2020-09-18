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

dependencies {
    // PaperMC Dependency
    compileOnly(paper())

    // Add your dependencies here
    // Examples
    // implementation("io.ktor:ktor-client:1.4.0") // Would be shaded into the final jar
    // compileOnly("io.ktor:ktor-client:1.4.0") // Only used on compile time
}

// This is your plugin.yml
spigot {
    name = "ExamplePlugin"
    authors = listOf("Me")
    commands {
        // Example command
        create("example") {
            description = "Example command"
            permission = "example.permission"
            aliases = listOf()
        }
    }
}

tasks {
    jar {
        // Disabled, because we use the shadowJar task for building our jar
        enabled = false
    }
    build {
        dependsOn("shadowJar")
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "1.8"
    }
}