buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:8.2.2")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.22")
        classpath("org.jetbrains.kotlin:kotlin-serialization:1.9.22")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        // 以下の2つのURLを優先的に探しに行くように設定します
        maven { url = uri("https://maven.mihon.app/outputs/maven") }
        maven { url = uri("https://jitpack.io") }
    }
}
