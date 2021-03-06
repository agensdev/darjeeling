plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("android.extensions")
    id("gitInfo")
    id("maven-publish")
}

android {
    compileSdkVersion(30)

    defaultConfig {
        minSdkVersion(21)
        targetSdkVersion(30)
        versionCode = gitInfo.count
        versionName = "0.91.1"

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

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
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
            url = uri("http://repo.agens.no:8081/nexus/content/repositories/oss-releases/")
            credentials {
                username = properties["nexus_deploy_user"] as String? ?: ""
                password = properties["nexus_deploy_pwd"] as String? ?: ""
            }
        }
    }
}

dependencies {
    runtimeOnly("org.jetbrains.kotlin:kotlin-stdlib:1.4.31")
    runtimeOnly("androidx.core:core-ktx:1.3.2")
    runtimeOnly("androidx.appcompat:appcompat:1.2.0")
    compileOnly("androidx.constraintlayout:constraintlayout:2.0.4")
    debugImplementation("androidx.fragment:fragment-testing:1.3.0")
    implementation("junit:junit:4.13.1")
    implementation("androidx.test.ext:junit:1.1.2")
    implementation("androidx.test.espresso:espresso-intents:3.3.0")
    implementation("androidx.test.espresso:espresso-contrib:3.3.0")
    implementation("androidx.test.espresso:espresso-core:3.3.0")

    api("androidx.fragment:fragment-testing:1.3.0")
}
