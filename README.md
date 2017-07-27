# SimpleToolbar
[![](https://jitpack.io/v/jaychang0917/SimpleToolbar.svg)](https://jitpack.io/#jaychang0917/SimpleToolbar)

An android toolbar extension.

## Installation
In your project level build.gradle :

```java
allprojects {
    repositories {
        ...
        maven { url "https://jitpack.io" }
    }
}
```

In your app level build.gradle :

```java
dependencies {
    compile 'com.github.jaychang0917:SimpleToolbar:{latest_version}'
}
```
[![](https://jitpack.io/v/jaychang0917/SimpleToolbar.svg)](https://jitpack.io/#jaychang0917/SimpleToolbar)


## Basic Usage
```xml
<com.jaychang.widget.stb.SimpleToolbar
    android:id="@+id/toolbar"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"

    app:stb_title="string"
    app:stb_titleTextColor="color"
    app:stb_titleTextSize="sp"
    app:stb_titleTextGravity="center|left(default)"
    app:stb_titleTextStyle="normal(default)|bold|italic"
    app:stb_titleTextIcon="drawable"
    app:stb_titleTextIconPosition="left(default)|right"

    app:stb_leftText="string"
    app:stb_leftTextColor="color"
    app:stb_leftTextIcon="drawable"
    app:stb_leftTextIconPosition="left(default)|right"
    app:stb_leftTextSize="sp"
    app:stb_leftIcon="@drawable/ic_back"
    app:stb_leftTextStyle="normal(default)|bold|italic"

    app:stb_rightText="string"
    app:stb_rightTextColor="color"
    app:stb_rightTextSize="sp"
    app:stb_rightTextStyle="normal(default)|bold|italic"
    app:stb_rightTextIcon="drawable"
    app:stb_rightTextIconPosition="left(default)|right"
    app:stb_rightIcon="drawable"
    app:stb_rightIcon2="drawable"
    app:stb_rightIcon3="drawable"
    app:stb_rightIcon4="drawable"
    app:stb_rightIcon5="drawable"
    />
```

## Global style attributes
You can apply styles for all SimpleToolbar instances in your app theme xml.
```xml
<style name="AppTheme" parent="Theme.AppCompat.Light.NoActionBar">
    <!-- ...-->
    
    <item name="simpleToolbarTextColor">@android:color/white</item>
    <item name="simpleToolbarTextStyle">normal</item>
    <item name="simpleToolbarTextSize">17sp</item>
    <item name="simpleToolbarTitleTextSize">20sp</item>
    <item name="simpleToolbarTitleTextColor">@android:color/white</item>
    <item name="simpleToolbarTitleTextStyle">bold</item>
    <item name="simpleToolbarTitleTextGravity">left</item>
    <item name="simpleToolbarHeight">56dp</item>
    <item name="simpleToolbarBackgroundColor">@color/colorPrimary</item>
</style>
```


## License
```
Copyright 2017 Jay Chang

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
