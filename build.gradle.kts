plugins {
    kotlin("multiplatform") version "1.9.0"
}

defaultTasks("clean", "build")

group = "com.koorosh"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven(
        url = uri("https://repo1.maven.org/maven2")
    )
}

kotlin {
    jvm {
        jvmToolchain(8)
        withJava()
        testRuns.named("test") {
            executionTask.configure {
                useJUnitPlatform()
            }
        }
    }

    val hostOs = System.getProperty("os.name")
    val isArm64 = System.getProperty("os.arch") == "aarch64"
    val isMingwX64 = hostOs.startsWith("Windows")
    val nativeTarget = when {
        hostOs == "Mac OS X" && isArm64 -> macosArm64("native")
        hostOs == "Mac OS X" && !isArm64 -> macosX64("native")
        hostOs == "Linux" && isArm64 -> linuxArm64("native")
        hostOs == "Linux" && !isArm64 -> linuxX64("native")
        isMingwX64 -> mingwX64("native")
        else -> throw GradleException("Host OS is not supported in Kotlin/Native.")
    }
    
    sourceSets {
        val commonMain by getting
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val jvmMain by getting {
            dependencies {
                // https://mvnrepository.com/artifact/io.github.java-native/jssc
                implementation("io.github.java-native:jssc:2.9.5")
            }
        }
        val jvmTest by getting
//        val nativeMain by getting
//        val nativeTest by getting
    }
}
