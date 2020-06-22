plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("android.extensions")
    id("gitInfo")
}

android {
    compileSdkVersion(29)
    buildToolsVersion = "29.0.3"

    defaultConfig {
        minSdkVersion(21)
        targetSdkVersion(29)
        versionCode = gitInfo.count
        versionName = "0.47"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
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