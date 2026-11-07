plugins {
    java
}

group = "dev.moonyxk.nocreepergrief"
version = "1.3.0"

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
}

val paperApi = "io.papermc.paper:paper-api:26.3.build.244-stable"

dependencies {
    compileOnly(paperApi)

    testImplementation(paperApi)
    testImplementation("org.junit.jupiter:junit-jupiter:5.13.4")
    testImplementation("org.mockito:mockito-core:5.24.0")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher:1.13.4")
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(25))
}

tasks.processResources {
    val pluginVersion = project.version.toString()
    inputs.property("version", pluginVersion)
    filesMatching("plugin.yml") {
        filter { line -> line.replace("\${version}", pluginVersion) }
    }
}

tasks.jar {
    from("LICENSE.txt")
}

tasks.test {
    useJUnitPlatform()
}
