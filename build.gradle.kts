plugins {
    alias(libs.plugins.android.application) apply false
    id("org.jetbrains.kotlin.android") version "2.2.0-Beta1" apply false
    alias(libs.plugins.compose.compiler) apply false
}
