plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.ksp)
    alias(libs.plugins.kapt)
    alias(libs.plugins.hilt)
    alias(libs.plugins.serialization.plugin)
    alias(libs.plugins.androidx.navigation.safe.args)
}

android {
    namespace = "com.example.edu.videotesttask"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.edu.videotesttask"
        minSdk = 26
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        ksp {
            arg("glideGeneratedClassPackage", "com.example.edu.videotesttask")
        }
    }

    sourceSets {
        named("main") {
            java.srcDirs("build/generated/ksp")
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            buildConfigField("String", "BASE_URL", "\"https://kinopoiskapiunofficial.tech/api/v2.2/\"")
            buildConfigField("String", "API_KEY", "\"b137c022-3d39-4f62-8639-e9232837f476\"")
        }

        debug{
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            buildConfigField("String", "BASE_URL", "\"https://kinopoiskapiunofficial.tech/api/v2.2/\"")
            buildConfigField("String", "API_KEY", "\"b137c022-3d39-4f62-8639-e9232837f476\"")

        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures{
        buildConfig = true
        viewBinding = true
    }
}

kotlin {
    jvmToolchain(17)
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    /**
     * dagger hilt
     */
    implementation(libs.hilt)
    ksp(libs.hilt.compiler)

    /**
     * Retrofit
     */
    implementation(libs.retrofit)
    implementation(libs.converter)

    /**
     * okhttp
     */
    implementation(libs.okhttp)
    implementation(libs.logging.interceptor)

    /**
     * kotlinx-serialization
     */
    implementation(libs.kotlinx.serialization)
    implementation(libs.kotlinx.serialization.converter)

    /**
     * navigation
     */
    implementation(libs.navigation.fragment)
    implementation(libs.navigation.ui)

    /**
     *Exoplayer
     */
    implementation(libs.exoplayer)
    implementation(libs.exoplayer.dash)
    implementation(libs.exoplayer.ui)

    /**
     * swipe to refresh
     */
    implementation(libs.swipe.to.refresh)

    /**
     * glide
     */
    implementation(libs.glide)
    kapt(libs.glide.kapt)
}