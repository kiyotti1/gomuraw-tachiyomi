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
        // ↓ この行を追加してください（Tachiyomiの部品置き場です）
        maven { url = uri("https://raw.githubusercontent.com/tachiyomidb/maven/master") }
        maven { url = uri("https://jitpack.io") }
    }
}

