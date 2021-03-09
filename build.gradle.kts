buildscript {
    val kotlin_version by extra("1.4.10")
    repositories {
        mavenLocal()
        google()
        jcenter()
        maven { url = java.net.URI("https://jitpack.io") }
    }
    dependencies {
        classpath("com.android.tools.build:gradle:4.1.2")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.10")
        classpath(files("libs/gitInfo-1.3.1.jar"))
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