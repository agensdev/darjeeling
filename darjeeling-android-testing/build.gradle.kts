import com.vanniktech.maven.publish.SonatypeHost

plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("android.extensions")
    id("com.vanniktech.maven.publish")
    id("maven-publish")
    signing
}

android {
    compileSdk = 30

    defaultConfig {
        minSdk = 21
        targetSdk = 30

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

mavenPublish {
    sonatypeHost = SonatypeHost.S01
}
