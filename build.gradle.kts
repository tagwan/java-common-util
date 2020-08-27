plugins {
    idea
    `java-library`
    java
    distribution
}

group = "com.github"
version = "1.0-SNAPSHOT"

repositories {
    val nexusUrl = "http://maven.aliyun.com/nexus/content/groups/public/"
    //mavenCentral()
    maven {
        setUrl(nexusUrl)
    }
}

dependencies {
    implementation("io.netty:netty-all:4.1.51.Final")
    testCompile("junit", "junit", "4.12")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}

tasks {
    withType<JavaCompile> {
        options.isFork = true
        options.encoding = "UTF-8"
    }

}