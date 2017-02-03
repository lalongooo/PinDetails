# PinDetails
A demo project showcasing how Google Maps for Android work.


![Screenshot of PinDetails](http://i.imgur.com/95qDqPC.png)


You can clone this project directly from Android Studio and click run.

#### Features:

* A Google Map is displayed in a Fragment.
* On long-press on the MapView, the device vibrates during 50 milliseconds and a [Marker](https://developers.google.com/maps/documentation/android-api/marker) is placed in the map.
* Information about the Marker on the map is displayed within a [Toast](https://developer.android.com/guide/topics/ui/notifiers/toasts.html) using [reverse geocoding](https://developer.android.com/training/location/display-address.html).
* The state of he map is saved using [`SharedPreferences`](https://developer.android.com/guide/topics/data/data-storage.html#pref), including the Marker. See [MapStateManager](https://github.com/lalongooo/PinDetails/blob/master/app/src/main/java/com/example/pindetails/util/MapStateManager.java).
* A couple of Android Instrumentation Tests have been implemented using [Espresso](https://google.github.io/android-testing-support-library/). See the [androidTest](https://github.com/lalongooo/PinDetails/tree/master/app/src/androidTest) directory.

#### To do:

* Show a progress indicator while fetching the address information using reverse geocoding.
* Display the address in a different dialog than toast (maybe snackbar).

#### Please, report the issues [here](https://github.com/lalongooo/PinDetails/issues/new).

### Made with :heart: in [Monterrey](https://www.google.com/maps?q=Monterrey) by [@lalongooo](https://twitter.com/lalongooo)
