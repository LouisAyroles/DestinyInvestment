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
    delete("$buildDir/backend")
    from("$projectDir/backend/build/install/backend")
    into("$buildDir/backend")
}

val copyFrontendToLocalBuildDir by tasks.register<Copy>("copyFrontendToLocalBuildDir") {
    delete("$buildDir/frontend")
    from("$projectDir/frontend/dist")
    into("$buildDir/frontend")
    duplicatesStrategy = DuplicatesStrategy.INCLUDE
}

val installDist by tasks.register("installDist") {
    val tasksToRun = listOf(
        clean,
        tasks.getByPath("frontend:installDist"),
        copyFrontendToLocalBuildDir,
        tasks.getByPath("backend:installDist"),
        copyBackendIntoLocalBuild
    )

    for (i in 0 until tasksToRun.lastIndex) {
        tasksToRun[i + 1].mustRunAfter(tasksToRun[i])
    }

    dependsOn(tasksToRun)
}