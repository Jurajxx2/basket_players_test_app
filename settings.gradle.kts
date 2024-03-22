pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Basket Players"
include(":app")
include(":features:home")
include(":features:player_list")
include(":features:player_detail")
include(":data:repositories")
include(":data:api")
include(":data:model")
include(":data:domain")
include(":common")
include(":features:team_list")
include(":features:team_detail")
