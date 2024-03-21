plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

apply(from = "$rootDir/gradle/publish.gradle")

android {
    compileSdk = 34
    namespace = "br.com.khomdrake.imperiya"

    defaultConfig {
        minSdk = 26

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    flavorDimensions += "uitool"
    productFlavors {
        create("compose") {
            dimension = "uitool"
        }
        create("views") {
            dimension = "uitool"
        }
    }

    publishing {
        singleVariant("release") {
            withSourcesJar()
            withJavadocJar()
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("debug")
        }
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.10"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.google.material)
    implementation(libs.toolkit.delegate)
    implementation(libs.toolkit.livedata)
    implementation(libs.toolkit.statemachine)
    implementation(libs.shimmer)
    implementation(libs.pagerindicator)
    api(platform(libs.androidx.compose.bom))
    api(libs.androidx.compose.runtime)
    api(libs.androidx.compose.material3)
    api(libs.androidx.compose.activity)
    api(libs.androidx.compose.livedata)
    api(libs.androidx.compose.constraintlayout)
    api(libs.androidx.compose.tooling.preview)

    implementation(libs.androidx.compose.tooling.debug)
    debugImplementation(libs.tests.compose.ui.manifest)

    // Test
    debugApi(libs.tests.androidx.fragment.testing)
    androidTestImplementation(libs.tests.mockk.normal) {
        exclude(module = "objenesis")
        exclude(module = "mockk-agent-jvm")
    }
    androidTestImplementation(libs.tests.mockk.android) {
        exclude(module = "objenesis")
        exclude(module = "mockk-agent-jvm")
    }
    androidTestImplementation(libs.tests.guava)
    androidTestImplementation(libs.tests.objenesis)
    androidTestImplementation(libs.tests.androidx.core.testing)
    androidTestImplementation(libs.tests.androidx.espresso.core)
    androidTestImplementation(libs.tests.androidx.espresso.contrib)
    androidTestImplementation(libs.tests.androidx.espresso.intents)
    androidTestImplementation(libs.tests.androidx.fragment.testing)
    androidTestImplementation(libs.tests.androidx.junit)
    androidTestImplementation(libs.tests.junit)
    androidTestImplementation(libs.tests.compose.ui.test)
}