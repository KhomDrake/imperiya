
<p align="center">
  
<img height="150" width="150" alt="Imperiya Icon" src="https://github.com/KhomDrake/imperiya/assets/23155918/3197a7f7-e109-4dbe-a5ee-b20fedf6f651">
</p>

# Imperiya

Is a Design System Library for helping me maintain the same visual throught all my apps.

## Getting started

The Library is divided into two flavors: Views and Compose. Is not necessary to use both flavors in your project, you just need to use the flavor you need.

To use Imperiya in the your module, implements the following depencies in `build.gradle` on the module:
```groovy
dependencies {
    def imperiya_last_release = '0.0.1'
    
    // Views Flavor
    implementation "io.github.khomdrake:imperiya:$imperiya_last_version:views@aar"
    
    // Compose Flavor
    implementation "io.github.khomdrake:imperiya:$imperiya_last_version:compose@aar"
}
```

After sync finishes, you can use the components from the library.

## Sample Apps

There is a application module called app, which is two apps that display the components of the library. One sample app for the Compose version and one for the Views version.

<img height="400" alt="Clean Architecture image 1" src="https://github.com/KhomDrake/imperiya/assets/23155918/d63db234-82a1-4368-83cb-867a5db405df">
<img height="400" alt="Clean Architecture image 1" src="https://github.com/KhomDrake/imperiya/assets/23155918/833f410a-b46b-4848-a8e7-5911013a9d1d">
<img height="400" alt="Clean Architecture image 1" src="https://github.com/KhomDrake/imperiya/assets/23155918/fa20288e-f77b-4805-a84f-877a8ee949c7">


## Why is named Imperiya?

I have a book idea where exist this really important crystal named Imperiya and I found that is a good name for this library. I used the idea of a crystal to be the icon for the sample app.


