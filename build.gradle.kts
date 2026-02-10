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
        // Mihon公式が推奨する代替リポジトリ
        maven { url = uri("https://raw.githubusercontent.com/mihonapp/maven/master") }
        maven { url = uri("https://jitpack.io") }
    }
}
