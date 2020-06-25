plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("android.extensions")
    id("gitInfo")
    id("maven-publish")
}

android {
    compileSdkVersion(29)
    buildToolsVersion("29.0.3")

    defaultConfig {
        minSdkVersion(21)
        targetSdkVersion(29)
        versionCode = gitInfo.count
        versionName = "0.61"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    lintOptions {
        isAbortOnError = false
    }
}

afterEvaluate {
    publishing {
        publications {
            // Creates a Maven publication called "release".
            create<MavenPublication>("release") {
                // Applies the component for the release build variant.
                from(components.getByName("release"))

                // You can then customize attributes of the publication as shown below.
                groupId = "no.agens.darjeeling"
                artifactId = "darjeeling-android-testing"
                version = project.android.defaultConfig.versionName
            }
        }
    }
}

publishing {
    repositories {
        maven {
            name = "AgensNexus"
            url = uri("https://repo.agens.no:8081")
            credentials {
                username = properties["nexus_deploy_user"] as String? ?: ""
                password = properties["nexus_deploy_pwd"] as String? ?: ""
            }
        }
    }
}

dependencies {
    runtimeOnly("org.jetbrains.kotlin:kotlin-stdlib:1.3.72")
    runtimeOnly("androidx.core:core-ktx:1.3.0")
    runtimeOnly("androidx.appcompat:appcompat:1.1.0")
    api("androidx.fragment:fragment-testing:1.2.5")
    api("junit:junit:4.12")
    api("androidx.test.ext:junit:1.1.1")
    api("androidx.test.espresso:espresso-intents:3.2.0")
    api("androidx.test.espresso:espresso-contrib:3.2.0")
    api("androidx.test.espresso:espresso-core:3.2.0")
}
