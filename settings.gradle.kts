import dev.scaffoldit.hytale.wire.HytaleManifest

rootProject.name = "HippoPlugin"

plugins {
    // See documentation on https://scaffoldit.dev
    id("dev.scaffoldit") version "0.2.+"
}

// Would you like to do a split project?
// Create a folder named "common", then configure details with `common { }`

hytale {
    usePatchline("release")
    useVersion("latest")

    repositories {
        // Any external repositories besides: MavenLocal, MavenCentral, HytaleMaven, and CurseMaven
    }

    dependencies {
        runtimeOnly("dev.scaffoldit:devtools:0.2.+")
    }

    manifest {
        Group = "HippoPlugin"
        Name = "HippoPlugin"
        Main = "fr.hippo.HippoPlugin"
        Version = "1.0.0"
        Authors = listOf(HytaleManifest.Author("Hippopo"))
    }
}