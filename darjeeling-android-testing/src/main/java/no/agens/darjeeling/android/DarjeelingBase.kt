package no.agens.darjeeling.android

import android.app.Activity
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.media.Image
import android.os.Build
import android.view.View
import android.widget.*
import androidx.annotation.*
import androidx.recyclerview.widget.RecyclerView

abstract class DarjeelingBase {

    abstract val activity: Activity

    fun editText(@IdRes resId: Int): EditText = activity.findViewById(resId)

    fun textView(@IdRes resId: Int): TextView = activity.findViewById(resId)

    fun button(@IdRes resId: Int): Button = activity.findViewById(resId)

    fun imageButton(@IdRes resId: Int): ImageButton = activity.findViewById(resId)

    fun imageView(@IdRes resId: Int): ImageView = activity.findViewById(resId)

    fun <T: View> view(@IdRes resId: Int): T = activity.findViewById(resId)

    fun checkBox(@IdRes resId: Int): CheckBox = activity.findViewById(resId)

    fun recyclerView(@IdRes resId: Int): RecyclerView = activity.findViewById(resId)

    fun string(@StringRes stringResId: Int): String =
        activity.resources.getString(stringResId)

    fun drawable(@DrawableRes resId: Int): Drawable = activity.resources.getDrawable(resId, activity.theme)

    @RequiresApi(Build.VERSION_CODES.M)
    fun color(@ColorRes resId: Int): Int = activity.resources.getColor(resId, activity.theme)

}