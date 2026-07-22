plugins {
    id("java")
}

java{
    toolchain {
        languageVersion.set(JavaLanguageVersion.of((property("javaVersion") as String)))
    }
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation(project(":cachemesh-proto"))

    runtimeOnly("io.grpc:grpc-netty-shaded:1.82.1")
    implementation("io.grpc:grpc-protobuf:1.82.1")
    implementation("io.grpc:grpc-stub:1.82.1")
    implementation("javax.annotation:javax.annotation-api:1.3.2")

}

tasks.test {
    useJUnitPlatform()
}