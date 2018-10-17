Soleeklab
==================

[![Build Status](https://travis-ci.org/mohamedebrahim96/Soleeklab.svg?branch=master)](https://travis-ci.org/mohamedebrahim96/Soleeklab.svg?branch=master)  [![Open Source Love](https://badges.frapsoft.com/os/v1/open-source.svg?v=103)](https://opensource.org/licenses/MIT) [![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

This is a pure Android application. <br>
It has the following features.
* Splash Screen. <br>
* Login Screen. <br>
* Signup Screen. <br>
* Firebase based Authentication. <br>
* Displays the list of countries form free api. (API   [here](https://restcountries.eu/)) <br>
* Has a Logout Button.
<br>
<hr>

Getting Started
---------------

- [Add Firebase to your Android Project](https://firebase.google.com/docs/android/setup).


### Google Sign In Setup

- Go to the [Firebase Console](https://console.firebase.google.com) and navigate to your project:
  - Select the **Auth** panel and then click the **Sign In Method** tab.
  - Click **Google** and turn on the **Enable** switch, then click **Save**.
- Run the sample app on your device or emulator.
    - Select **GoogleSignInActivity** from the main screen.
    - Click the **Sign In** button to begin.
    
### Email/Password Setup

- Go to the [Firebase Console](https://console.firebase.google.com) and navigate to your project:
  - Select the **Auth** panel and then click the **Sign In Method** tab.
  - Click **Email/Password** and turn on the **Enable** switch, then click **Save**.
  - Under **Authorized Domains** click **Add Domain** and add `auth.example.com`.
- Run the app on your device or emulator.
    - Select **EmailPasswordActivity** from the main screen.
    - Fill in your desired email and password and click **Create Account** to begin.
    
    
Result
-----------
<img src="/Screenshot_2018-10-17-19-00-33-446.jpeg" height="534" width="300"/><img src="/Screenshot_2018-10-17-19-00-54-571.jpeg" height="534" width="300"/>
<img src="/Screenshot_2018-10-17-19-00-21-646.jpeg" height="534" width="300"/><img src="/Screenshot_2018-10-17-19-02-50-906.jpeg" height="534" width="300"/>
    

1. The apk is there in the APK folder and also present in app>release>app-release.apk
2.Code comprises of three Activities.
  	a.login.java(main)
	b.Register.java
	c.DashboardActivity.java
3.It comprises of three layouts respectively.
	a.activity_main.xml
	b.activity_register.xml
	c.activity_dashboard.xml
**********************************************************************************

Developer setup
---------------

### Requirements

- Java 8
- Latest version of Android SDK and Android Build Tools

### API Key

The app uses themoviedb.org API to get movie information and posters. You must provide your own [API key][1] in order to build the app.

Just put your API key into `~/.gradle/gradle.properties` file (create the file if it does not exist already):

```gradle
MY_MOVIE_DB_API_KEY="abc123"
```

### Building

You can build the app with Android Studio or with `./gradlew assembleDebug` command.

### Testing

This project integrates a combination of [local unit tests][2], [instrumented tests][3] and [code analysis tools][4].

Just run `build.sh` to ensure that project code is valid and stable.
This will run local unit tests on the JVM, instrumented tests on connected device (or emulator) and analyse code with Checkstyle, Findbugs and PMD.


## Versioning

For transparency and insight into our release cycle, and for striving to maintain backward compatibility, PlexMedia will be maintained according to the [Semantic Versioning](http://semver.org/) guidelines as much as possible.

Releases will be numbered with the following format:

`<major>.<minor>.<patch>-<build>`

Constructed with the following guidelines:

* A new *major* release indicates a large change where backward compatibility is broken.
* A new *minor* release indicates a normal change that maintains backward compatibility.
* A new *patch* release indicates a bugfix or small change which does not affect compatibility.
* A new *build* release indicates this is a pre-release of the version.


***

If you distribute a copy or make a fork of the project, you have to credit this project as the source.

This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.

This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details.

You should have received a copy of the GNU General Public License along with this program.  If not, see http://www.gnu.org/licenses/ .

***


License
-------

    Copyright 2018 mohamedebrahim96

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
