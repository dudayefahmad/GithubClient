object AndroidConfig {
    const val compileSdkVersion = 32
    const val minSdkVersion = 21
    const val targetSdkVersion = 32
    const val versionCode = 1
    const val versionName = "1.0"
}

object Versions {
    const val kotlin = "1.7.10"
    const val coreKtx = "1.8.0"
    const val appCompat = "1.5.0"
    const val material = "1.6.1"
    const val constraintLayout = "2.1.4"
    const val dataStore = "1.0.0"
    const val navigationComponent = "2.5.1"
    const val hilt = "2.43.2"
    const val lifecycle = "2.5.1"
    const val coroutines = "1.6.4"
    const val retrofit = "2.9.0"
    const val moshi = "1.13.0"
    const val loggingInterceptor = "4.10.0"
    const val coil = "2.2.0"
    const val room = "2.4.3"
    const val jUnit = "4.13.2"
    const val androidTestJunit = "1.1.3"
    const val androidTestEspressoCore = "3.4.0"
    const val circleImageViewVersion = "3.1.0"
}


object AndroidLib {
    const val kotlinStdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
    const val androidxCore = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val androidxAppcompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val preferencesDataStore = "androidx.datastore:datastore-preferences:${Versions.dataStore}"
    const val navFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navigationComponent}"
    const val navUi = "androidx.navigation:navigation-ui-ktx:${Versions.navigationComponent}"
    const val navDynamicFeatureFragment = "androidx.navigation:navigation-dynamic-features-fragment:${Versions.navigationComponent}"
    const val androidxConstraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val hilt = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val hiltCompiler = "com.google.dagger:hilt-compiler:${Versions.hilt}"
    const val hiltAndroidCompiler = "androidx.hilt:hilt-compiler:${Versions.hilt}"
    const val hiltViewModel = "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.hilt}"
    const val viewmodel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val livedata = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
    const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val moshi = "com.squareup.moshi:moshi-kotlin:${Versions.moshi}"
    const val retrofitMoshi = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"
    const val okhttpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.loggingInterceptor}"
    const val coil = "io.coil-kt:coil:${Versions.coil}"
    const val room = "androidx.room:room-runtime:${Versions.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
    const val circleImage = "de.hdodenhof:circleimageview:${Versions.circleImageViewVersion}"
}

object AndroidTestLib {
    const val jUnit = "junit:junit:${Versions.jUnit}"
    const val androidTestJUnit = "androidx.test.ext:junit:${Versions.androidTestJunit}"
    const val androidTestEspressoCore = "androidx.test.espresso:espresso-core:${Versions.androidTestEspressoCore}"
    const val androidTestNavigation = "androidx.navigation:navigation-testing:${Versions.navigationComponent}"
}