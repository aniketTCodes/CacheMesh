plugins {
    id("java")
    id("com.google.protobuf") version "0.9.5"
}

java{
    toolchain {
        languageVersion.set(JavaLanguageVersion.of((property("javaVersion") as String)))
    }
}

sourceSets{
    main {
        java.srcDirs (layout.buildDirectory.dir("generated/source"))
    }
}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:3.25.8"
    }

    plugins {
        create("grpc") {
            artifact = "io.grpc:protoc-gen-grpc-java:1.82.1"
        }
    }

    generateProtoTasks {
        all().forEach { task ->
            task.plugins {
                create("grpc")
            }
        }
    }
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    runtimeOnly("io.grpc:grpc-netty-shaded:1.82.1")
    implementation("io.grpc:grpc-protobuf:1.82.1")
    implementation("io.grpc:grpc-stub:1.82.1")
    implementation("javax.annotation:javax.annotation-api:1.3.2")
}

tasks.test {
    useJUnitPlatform()
}