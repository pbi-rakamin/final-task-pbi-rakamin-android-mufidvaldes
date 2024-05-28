plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id ("kotlin-parcelize")
}

android {
    namespace = "com.rakamin_finaltask.news_app_final"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.rakamin_finaltask.news_app_final"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    buildFeatures {
        viewBinding = true
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    // UI Material
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation ("androidx.recyclerview:recyclerview:1.3.2")
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

    implementation ("com.github.bumptech.glide:glide:4.16.0")
    implementation ("androidx.viewpager2:viewpager2:1.1.0")
    implementation ("androidx.fragment:fragment-ktx:1.7.1")
    // Testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // Retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.7")

    // Coroutine Support
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.0") //viewModelScope
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.8.0") //liveData
    implementation ("androidx.room:room-ktx:2.6.1")
}