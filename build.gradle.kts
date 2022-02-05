repositories {
    mavenCentral()
}

subprojects {
    repositories {
        mavenCentral()
    }
}

val clean by tasks.register("clean") {
    delete(buildDir)

    dependsOn(
        tasks.getByPath("backend:clean")
    )
}


val copyBackendIntoLocalBuild by tasks.register<Copy>("copyBackendIntoLocalBuild") {
    from("$projectDir/backend/build/install/backend")
    into("$buildDir/backend")
}

val copyFrontendIntoBackendResources by tasks.register<Copy>("copyFrontendIntoBackendResources") {
    from("$projectDir/frontend/dist")
    into("$projectDir/backend/src/main/resources/static")
}

val installDist by tasks.register("installDist") {
    val tasksToRun = listOf(
        clean,
        tasks.getByPath("frontend:installDist"),
        copyFrontendIntoBackendResources,
        tasks.getByPath("backend:installDist"),
        copyBackendIntoLocalBuild
    )

    for (i in 0 until tasksToRun.lastIndex) {
        tasksToRun[i + 1].mustRunAfter(tasksToRun[i])
    }

    dependsOn(tasksToRun)
}