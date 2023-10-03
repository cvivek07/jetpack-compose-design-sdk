[[_TOC_]]

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
    implementation "com.ixigo.sdk:ixigo-design-sdk:1.0.4"
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

# Usage

A user interface element that displays text to the user.
To provide user-editable text, see [IxiLinedInputField] and [IxiOutlinedInputField].

The following code sample shows a typical use, with an XML layout
and code to modify the contents of the text view:

```
<com.ixigo.design.sdk.components.text.IxiText
       android:id="@+id/text_view_id"
       android:layout_height="wrap_content"
       android:layout_width="wrap_content"
       android:textColor="@color/o700"
       android:text="@string/hello" >
```

This code sample demonstrates how to modify the contents of the text view
defined in the previous XML layout:

```
public class MainActivity extends Activity {

protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final IxiText helloTextView = (IxiText) findViewById(R.id.text_view_id);
        helloTextView.setText("Hello World");
    }
}
```
To customize the appearance of IxiText, Modify [IxiTypography]'s properties.
```
IxiTypography.Body.XSmall.regular.copy(fontSize = 20.dp)
IxiTypography.Body.XSmall.regular.copy(letterSpacing = 1.sp,)
IxiTypography.Body.XSmall.regular.copy(lineHeight = 23.4.sp,)
IxiTypography.Body.XSmall.regular.copy(fontWeight = W500,)
IxiTypography.Body.XSmall.regular.copy(fontFamily = IxiFamily)
```

# Development

Most of the development should be done against Unit Tests and against our Sample App.

### Development inside other Apps

If you want to modify ixigo-design-sdk and test it quickly inside other Apps, we recommend publishing ixigo-design-sdk to your maven local repository and configure your app to read from maven local repository.

To push to your local maven repository:

**Release**
```shell
./gradlew ixigo-design-sdk:publishReleasePublicationToMavenLocal
```

**Snapshot**
```shell
./gradlew ixigo-design-sdk:publishSnapshotPublicationToMavenLocal
```

Once it is pushed in your local maven repository, configure your App to use `mavenLocal()` giving it a higher priority than `ixigo-design-sdk` repository

```groovy
repositories {
  mavenLocal()
  ...
  // ixigo-design-sdk repository
}
```

# Available Components

This SDK provides the following components:

### Buttons
Buttons allow users to take actions, and make choices, with a single tap.

https://www.figma.com/file/WYm8OYDqRTjzIYjgVRfS2E/Components?type=design&node-id=703-4284&mode=design&t=UdbrnsPY7euxQxTu-0

### Input Fields
Input fields allow users to enter text into a UI. They typically appear in forms and dialogs.

https://www.figma.com/file/WYm8OYDqRTjzIYjgVRfS2E/Components?type=design&node-id=1014-155849&mode=design&t=UdbrnsPY7euxQxTu-0

### Typography
This includes various text styles and typographic patterns that are pre-configured and can be easily reused across your project.

### Progress Step
Progress Step is used during multi-step processes to indicate the user's current step in the process.

https://www.figma.com/file/WYm8OYDqRTjzIYjgVRfS2E/Components?type=design&node-id=1028-171705&mode=design&t=UdbrnsPY7euxQxTu-0

### TopAppBar
TopAppBar is a container for items such as application title, navigation icon, and action items.

https://www.figma.com/file/WYm8OYDqRTjzIYjgVRfS2E/Components?type=design&node-id=926-105703&mode=design&t=UdbrnsPY7euxQxTu-0

### TabBar
TabBar is a horizontal list of tabs where each tab component is associated with different content.

https://www.figma.com/file/WYm8OYDqRTjzIYjgVRfS2E/Components?type=design&node-id=956-59669&mode=design&t=UdbrnsPY7euxQxTu-0

### AutoCompleter
AutoCompleter is a text input field that gives real-time suggestions or completion options to the user as they type.

### ListItem
ListItem is a single row in a list. It can contain simply text or more complex layouts with multiple segments or buttons.

https://www.figma.com/file/WYm8OYDqRTjzIYjgVRfS2E/Components?type=design&node-id=979-62929&mode=design&t=UdbrnsPY7euxQxTu-0

### Bottom Navigation
Bottom Navigation provides quick navigation between top-level views of an app with a bottom navigation bar.

https://www.figma.com/file/WYm8OYDqRTjzIYjgVRfS2E/Components?type=design&node-id=1124-239705&mode=design&t=UdbrnsPY7euxQxTu-0

### Chips
Chips are compact elements that represent an attribute, text, entity or action.

https://www.figma.com/file/WYm8OYDqRTjzIYjgVRfS2E/Components?type=design&node-id=1819-250785&mode=design&t=UdbrnsPY7euxQxTu-0

### Bottom Sheet
Bottom Sheet is a sheet that slides up from the bottom edge of the screen. Bottom sheets are used to display content that supplements the main screen.

https://www.figma.com/file/WYm8OYDqRTjzIYjgVRfS2E/Components?type=design&node-id=2283-377454&mode=design&t=UdbrnsPY7euxQxTu-0

### Inline Alert
Inline Alert is a concise message that is displayed in-line with UI content and aims to provide pertinent information or feedback to the user.

https://www.figma.com/file/WYm8OYDqRTjzIYjgVRfS2E/Components?type=design&node-id=1172-214222&mode=design&t=UdbrnsPY7euxQxTu-0

### Sticky Alert
Sticky Alert is a special type of alert message that stays at a fixed position (usually top of the page) for persistent user visibility, regardless of scrolling.

https://www.figma.com/file/WYm8OYDqRTjzIYjgVRfS2E/Components?type=design&node-id=1173-214429&mode=design&t=UdbrnsPY7euxQxTu-0

### Separator
Separator is a line or space that visually divides content into sections.

https://www.figma.com/file/WYm8OYDqRTjzIYjgVRfS2E/Components?type=design&node-id=1028-171569&mode=design&t=UdbrnsPY7euxQxTu-0


# Release a new version

To release a new version:

1. Push a commit with a higher version to the components branch.
2. In the pipeline page, find the pipeline with the above commit.
3. Click on ▶ in the `release` job to release the sdk