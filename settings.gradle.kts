enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    plugins {
        id("com.google.devtools.ksp") version "1.8.21-1.0.11"
        id("dev.rikka.tools.refine") version "4.3.0"
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        mavenLocal {
            content {
                includeGroup("io.github.libxposed")
            }
        }
    }
    versionCatalogs {
        create("libs") {
            from(files("core/gradle/libs.versions.toml"))
        }
    }
}

rootProject.name = "LSPatch"
include(
    ":apkzlib",
    ":core",
    ":hiddenapi:bridge",
    ":hiddenapi:stubs",
    ":jar",
    ":manager",
    ":meta-loader",
    ":patch",
    ":patch-loader",
    ":services:daemon-service",
    ":services:manager-service",
    ":services:xposed-service:interface",
    ":share:android",
    ":share:java",
)

project(":core").projectDir = file("core/core")
project(":hiddenapi:bridge").projectDir = file("core/hiddenapi/bridge")
project(":hiddenapi:stubs").projectDir = file("core/hiddenapi/stubs")
project(":services:daemon-service").projectDir = file("core/services/daemon-service")
project(":services:manager-service").projectDir = file("core/services/manager-service")
project(":services:xposed-service:interface").projectDir = file("core/services/xposed-service/interface")

buildCache { local { removeUnusedEntriesAfterDays = 1 } }
