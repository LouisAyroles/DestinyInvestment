import com.github.gradle.node.npm.task.NpmTask

plugins {
    id("com.github.node-gradle.node") version "3.1.1"
}

tasks.create<NpmTask>("deploy") {
    args.set(listOf("run", "generate"))
}

node {
    npmVersion.set("8.1.2")
    download.set(true)
}
