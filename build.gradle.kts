

plugins{
}

allprojects{
    group = "com.cachemesh"
    version = property("projectVersion") as String

    repositories{
        mavenCentral()
    }
}

subprojects{
    tasks.withType<Test>().configureEach {
        useJUnitPlatform()
    }
}