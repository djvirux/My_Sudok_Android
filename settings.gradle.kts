/*
 * *
 * Created by VrX on 6/9/23 20:49
 * Copyright (c) 2023
 * Last modified 17/8/23 21:53
 * /
 */

pluginManagement {
    repositories {
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
    }
}

rootProject.name = "My Sudok"
include(":app")
