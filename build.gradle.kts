buildscript {
    repositories {
        mavenLocal()
        google()
        jcenter()
        maven { url = java.net.URI("https://jitpack.io") }
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.0.1")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.31")
        classpath("com.vanniktech:gradle-maven-publish-plugin:0.15.0")
    }
}

allprojects {
    repositories {
        mavenLocal()
        google()
        jcenter()
    }
}

tasks {
    val clean by registering(Delete::class) {
        delete(buildDir)
    }
}