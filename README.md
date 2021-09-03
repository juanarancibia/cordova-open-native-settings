# Information
Plugin for Cordova 7 based on [cordova-open-native-settings](https://github.com/guyromb/cordova-open-native-settings). Modified the android source code and only can open wifi settings.
In order to open other native settings in android just add in this [file](./src/android/NativeSettings.java) a new condition like
```java
    if (action.equals("wifi")) {
        	intent = new Intent(android.provider.Settings.ACTION_WIFI_SETTINGS);
        }
```
You can get android settings list in [Android Docs](https://developer.android.com/reference/android/provider/Settings)

## Adding/Removing the Plugin
It will be saved to the config.xml file
Cordova:

```bash
cordova plugin (add|rm) @juanarancibia/cordova-open-native-settings --save
```

or via npm (It will be saved to the package.json file)

```bash
npm (install|uninstall) @juanarancibia/cordova-open-native-settings --save
```

## Using the plugin (opens Location Settings in Android and Application Settings in iOS)

```
cordova.plugins.settings.open(setting_constant, success_callback, failure_callback);
```

### Example for iOS and Android - open Wifi settings

```js
if (window.cordova && window.cordova.plugins.settings) {
    console.log('openNativeSettingsTest is active');
    window.cordova.plugins.settings.open("wifi", function() {
            console.log('opened settings');
        },
        function () {
            console.log('failed to open settings');
        }
    );
} else {
    console.log('openNativeSettingsTest is not active!');
}
```

In Android, by default it is opened in the same application as a new activity, the hardware back button will bring the user back to the previous activity (the app). In order to open settings as a new application (two applications will appear in "recent/opened" apps list) the following code can be used:
`window.cordova.plugins.settings.open(["wifi", true], function() {}, function() {}); ....`

## Settings Options (Android)

Setting constant | Description
-----------------|------------
"wifi" | Show settings to allow configuration of Wi-Fi


## Settings Options (iOS)

Setting constant | Description
-----------------|------------
"about" | Settings > General > About
"accessibility" | Settings > General > Accessibility
"account" | Settings > _Your name_
"airplane_mode" | Settings > Airplane Mode
"application_details" | Settings
"autolock" | Settings > General > Auto-Lock (before iOS 10)
"battery" | Settings > Battery
"bluetooth" | Settings > General > Bluetooth (before iOS 9)<br>Settings > Bluetooth (after iOS 9)
"browser" | Settings > Safari
"castle" | Settings > iCloud
"cellular_usage" | Settings > General > Cellular Usage
"configuration_list" | Settings > General > Profile
"date" | Settings > General > Date & Time
"display" | Settings > Display & Brightness
"do_not_disturb" | Settings > Do Not Disturb
"facetime" | Settings > Facetime
"keyboard" | Settings > General > Keyboard
"keyboards" | Settings > General > Keyboard > Keyboards
"locale" | Settings > General > Language & Region
"location" | Settings > Location Services (in older versions of iOS)
"locations" | Settings > Privacy > Location Services (in newer versions of iOS)
"tracking" | Settings > Privacy > Tracking (iOS 14+)
"mobile_data" | Settings > Mobile Data (after iOS 10)
"music" | Settings > iTunes
"music_equalizer" | Settings > Music > EQ
"music_volume" | Settings > Music > Volume Limit
"network" | Settings > General > Network
"nike_ipod" | Settings > Nike + iPod
"notes" | Settings > Notes
"notification_id" | Settings > Notifications
"passbook" | Settings > Passbook & Apple Pay
"phone" | Settings > Phone
"photos" | Settings > Photo & Camera
"privacy" | Settings > Privacy
"reset" | Settings > General > Reset
"ringtone" | Settings > Sounds > Ringtone
"search" | Settings > General > Assistant (before iOS 10)<br>Settings > Siri (after iOS 10)
"settings" | Settings > General
"sound" | Settings > Sounds
"software_update" | Settings > General > Software Update
"storage" | Settings > iCloud > Storage & Backup
"store" | Settings > iTunes & App Store
"tethering" | Settings > Personal Hotspot
"touch" | Settings > Touch ID & Passcode
"twitter" | Settings > Twitter
"usage" | Settings > General > Storage & iCloud Usage
"video" | Settings > Video
"vpn" | Settings > General > VPN
"wallpaper" | Settings > Wallpaper
"wifi" | Settings > WIFI

## Notes
* Android plugin based on the following information: https://developer.android.com/reference/android/provider/Settings.html#ACTION_DREAM_SETTINGS
* iOS plugin based on the following information: https://gist.github.com/phynet/471089a51b8f940f0fb4
* In iOS, this plugin generates a URL scheme for the *-Info.plist configurations file.
* The plugin for Android is based on the forked repository and was refactored. The iOS part was built from skretch.

## License
```
The MIT License

Copyright (c) 2021 Juan Cruz Arancibia

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
```
