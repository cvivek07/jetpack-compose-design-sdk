# Installation

Follow following Steps to Add this library into your project.

## Add dependency

Inside **root/build.gradle**

```groovy
buildscript {
    repositories {
        maven { url 'https://nexus.ixigo.com/nexus/content/repositories/androidshared' }
    }
}

```

Alternatively we can add Special Maven repository in *dependencyResolutionManagement*
in **root/settings.gradle**, in case your **root/build.gradle** does not have option.

```groovy
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url 'https://nexus.ixigo.com/nexus/content/repositories/androidshared' }
    }
}
```

Inside **app/build.gradle**

```groovy
dependencies {
    implementation "com.ixigo.sdk:ixigo-design-sdk:1.0.0-alpha1"
}

```

Inside **app/build.gradle**, Add Following Dependencies in Your project along with Design Sdk.

```groovy
dependencies {

// Compose Material Design
    implementation 'androidx.compose.material:material:1.3.1'
// Tooling support (Previews, etc.)
    implementation 'androidx.compose.ui:ui-tooling:1.3.2'
}
```

Inside **app/build.gradle**, add following code

```groovy
android {
    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.2"
    }

    buildFeatures {
        compose true
    }
}
```
