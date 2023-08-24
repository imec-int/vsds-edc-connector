plugins {
    `java-library`
    id("java")
}

group = "be.imec.edc"
version = "unspecified"

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.edc.data.plane.http)
    implementation(libs.edc.data.plane.util)
    implementation(libs.edc.util)

    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}