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
        // Keiyoushiのリポジトリ（現在、拡張機能の多くがここを参照しています）
        maven { url = uri("https://maven.keiyoushi.org/repository/maven-public/") }
        maven { url = uri("https://raw.githubusercontent.com/mihonapp/maven/master") }
        maven { url = uri("https://jitpack.io") }
    }
}
