rootProject.name = "spigot-gradle-kotlin-template"

pluginManagement {
    val kotlin_version: String by settings
    val spigradle_version: String by settings
    val shadow_version: String by settings

    plugins {
        kotlin("jvm") version kotlin_version
        id("kr.entree.spigradle") version spigradle_version
        id("com.github.johnrengelman.shadow") version shadow_version
    }
}