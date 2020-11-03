plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
}

android {
    compileSdkVersion(29)
    buildToolsVersion("29.0.3")

    defaultConfig {
        applicationId = "no.agens.darjeeling"
        minSdkVersion(21)
        targetSdkVersion(29)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
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
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.4.10")
    implementation("androidx.core:core-ktx:1.3.2")
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("org.koin:koin-core:2.1.5")
    implementation("org.koin:koin-android:2.1.5")
    implementation("androidx.constraintlayout:constraintlayout:2.0.3")
    testImplementation("junit:junit:4.13.1")
    debugImplementation("androidx.fragment:fragment-testing:1.2.5") {
        exclude(group = "androidx.test", module = "core")
    }
    androidTestImplementation("junit:junit:4.13.1")
    androidTestImplementation("org.assertj:assertj-core:3.17.1")
    androidTestImplementation("androidx.test.ext:junit:1.1.2")
    androidTestImplementation("androidx.test:runner:1.3.0")
    androidTestImplementation("androidx.test:core:1.3.0")
    androidTestImplementation("org.koin:koin-test:2.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-intents:3.3.0")
    androidTestImplementation("io.mockk:mockk-android:1.10.0")
    androidTestImplementation(project(":darjeeling-android-testing"))
}