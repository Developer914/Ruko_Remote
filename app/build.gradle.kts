plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("kotlin-kapt")
    alias(libs.plugins.hilt)
}

android {
    namespace = "com.example.roku"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.roku"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    hilt {
        enableAggregatingTask = false
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    // SplashScreen API
    implementation(libs.androidx.core.splashscreen)

    // Dots indicator for onboarding
    implementation(libs.dotsindicator)

    // Navigation runtime
    implementation(libs.androidx.navigation.runtime.ktx)
    implementation(libs.androidx.runtime.livedata)
    implementation(libs.androidx.appcompat)

    // Testing libraries
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)

    // Debugging tools
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    // Fonts
    implementation(libs.androidx.ui.text)

    // SDP/SSP
    //implementation(libs.sdp.compose)

    // Google Billing
    implementation(libs.billing)
    implementation(libs.billing.ktx)

    // Hilt for Dependency Injection
    implementation(libs.hilt.android) // Hilt library
    kapt(libs.hilt.compiler)          // Hilt compiler for annotation processing
    implementation(libs.androidx.hilt.navigation.compose) // Hilt navigation for Compose

    // Force JavaPoet version to resolve the Hilt issue
    implementation(libs.javapoet) // This ensures compatibility with Hilt

    // Preferences management
    implementation(libs.easyprefs)

    // timber
    implementation(libs.timber)
    // LiveData
    implementation (libs.androidx.lifecycle.livedata.ktx)

    // dots indicator
    implementation(libs.dotsindicator.v510)

    // accompanist
    implementation(libs.accompanist.systemuicontroller)

    implementation(libs.androidx.foundation)

}