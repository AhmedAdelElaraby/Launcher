pluginManagement {
    repositories {


        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
                maven("https://jitpack.io") // أضف هذا السطر

            }
        }

        google()
        mavenCentral()
        gradlePluginPortal()



    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io") // مستودع JitPack

     }
}

rootProject.name = "Launcher"
include(":app")
 