plugins {
    id("dev.rontran.java.tutorials.java-application-conventions")
}

val jacksonVersion by extra("2.16.1")
val lombokVersion by extra("1.18.30")

dependencies {
    implementation("com.fasterxml.jackson.core:jackson-databind:$jacksonVersion")
    compileOnly("org.projectlombok:lombok:$lombokVersion")
    annotationProcessor("org.projectlombok:lombok:$lombokVersion")
}