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
        versionName = "0.58"

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
                version = project.version.toString()
//                artifact("$buildDir/outputs/aar/darjeeling-android-testing-release.aar")
            }
        }
    }
}

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/agensdev/darjeeling")
            credentials {
                username = System.getenv("GITHUB_ACTOR")
                password = System.getenv("GITHUB_TOKEN")
            }
        }
    }
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.3.72")
    implementation("androidx.core:core-ktx:1.3.0")
    implementation("androidx.appcompat:appcompat:1.1.0")
    implementation("androidx.fragment:fragment-testing:1.2.5")
    implementation("junit:junit:4.12")
    implementation("androidx.test.ext:junit:1.1.1")
    implementation("androidx.test.espresso:espresso-core:3.2.0")
    implementation("androidx.test.espresso:espresso-intents:3.2.0")
    implementation("androidx.test.espresso:espresso-contrib:3.2.0")
    implementation("androidx.test:core:1.2.0")
    implementation("androidx.test:rules:1.2.0")
    implementation("androidx.test:runner:1.2.0")
}
