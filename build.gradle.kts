repositories {
    mavenCentral()
}

subprojects {
    repositories {
        mavenCentral()
    }
}


val copyBackendIntoLocalBuild by tasks.register<Copy>("copyBackendIntoLocalBuild") {
    from("$projectDir/backend/build/install/backend")
    into("$buildDir/backend")
}

val copyFrontendIntoLocalBuild by tasks.register<Copy>("copyFrontendIntoLocalBuild") {
    from("$projectDir/frontend/dist")
    into("$buildDir/frontend")
}

val buildForDeployment by tasks.register("buildForDeployment") {
    val tasksToRun = listOf(
        tasks.getByPath("backend:installDist"),
        copyBackendIntoLocalBuild,
        tasks.getByPath("frontend:deploy"),
        copyFrontendIntoLocalBuild
    )

    for (i in 0 until tasksToRun.lastIndex) {
        tasksToRun[i + 1].mustRunAfter(tasksToRun[i])
    }

    dependsOn(tasksToRun)
}