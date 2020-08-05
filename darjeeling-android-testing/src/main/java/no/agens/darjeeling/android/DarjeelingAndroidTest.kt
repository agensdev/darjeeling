package no.agens.darjeeling.android

import androidx.appcompat.app.AppCompatActivity
import kotlin.reflect.KClass


@Deprecated("Replaced by DarjeelingActivityTest")
abstract class DarjeelingAndroidTest<T : AppCompatActivity>(
    activityClass: KClass<T>) : DarjeelingActivityTest<T>(activityClass)