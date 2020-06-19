package no.agens.darjeeling.android

import android.app.Activity
import android.view.View
import android.widget.*
import androidx.annotation.IdRes
import androidx.annotation.StringRes

abstract class DarjeelingViewExtensions {

    abstract val activity: Activity

    fun editText(@IdRes resId: Int): EditText = activity.findViewById(resId)

    fun textView(@IdRes resId: Int): TextView = activity.findViewById(resId)

    fun button(@IdRes resId: Int): Button = activity.findViewById(resId)

    fun imageButton(@IdRes resId: Int): ImageButton = activity.findViewById(resId)

    fun view(@IdRes resId: Int): View = activity.findViewById(resId)

    fun checkBox(@IdRes resId: Int): CheckBox = activity.findViewById(resId)

    fun string(@StringRes stringResId: Int): String =
        activity.resources.getString(stringResId)

}