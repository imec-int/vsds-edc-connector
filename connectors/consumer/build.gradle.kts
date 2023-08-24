plugins {
    `java-library`
    id("application")
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "be.imec.edc"
version = "1.0-SNAPSHOT"
val edcVersion = "0.2.1"

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.edc.control.plane.core)
    implementation(libs.edc.dsp)
    implementation(libs.edc.configuration.filesystem)
    implementation(libs.edc.vault.filesystem)
    implementation(libs.edc.iam.mock)
    implementation(libs.edc.management.api)
    implementation(libs.edc.transfer.data.plane)
    implementation(libs.edc.transfer.pull.http.receiver)

    implementation(libs.edc.data.plane.selector.api)
    implementation(libs.edc.data.plane.selector.core)
    implementation(libs.edc.data.plane.selector.client)

    implementation(libs.edc.data.plane.api)
    implementation(libs.edc.data.plane.core)
    implementation(libs.edc.data.plane.http)

    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

application {
    mainClass.set("org.eclipse.edc.boot.system.runtime.BaseRuntime")
    applicationDefaultJvmArgs = listOf(
        "-Dedc.keystore=${projectDir}/../certificate/cert.pfx",
        "-Dedc.keystore.password=123456",
        "-Dedc.vault=${projectDir}/vault.properties",
        "-Dedc.fs.config=${projectDir}/configuration.properties"
    )
}

tasks.test {
    useJUnitPlatform()
}