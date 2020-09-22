package no.agens.darjeeling.android

import android.app.Activity
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.media.Image
import android.os.Build
import android.view.View
import android.widget.*
import androidx.annotation.*
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

abstract class DarjeelingBase {

    abstract val activity: Activity

    fun relativeLayout(@IdRes resId: Int): RelativeLayout = view(resId)

    fun constraintLayout(@IdRes resId: Int): ConstraintLayout = view(resId)

    fun linearLayout(@IdRes resId: Int): LinearLayout = view(resId)

    fun cardView(@IdRes resId: Int): CardView = view(resId)

    fun progressBar(@IdRes resId: Int): ProgressBar = view(resId)

    fun editText(@IdRes resId: Int): EditText = view(resId)

    fun textView(@IdRes resId: Int): TextView = view(resId)

    fun button(@IdRes resId: Int): Button = view(resId)

    fun imageButton(@IdRes resId: Int): ImageButton = view(resId)

    fun imageView(@IdRes resId: Int): ImageView = view(resId)

    fun checkBox(@IdRes resId: Int): CheckBox = view(resId)

    fun recyclerView(@IdRes resId: Int): RecyclerView = view(resId)

    fun <T : View> view(@IdRes resId: Int): T = activity.findViewById(resId)

    fun string(@StringRes stringResId: Int): String =
        activity.resources.getString(stringResId)

    fun drawable(@DrawableRes resId: Int): Drawable = activity.resources.getDrawable(resId, activity.theme)

    @RequiresApi(Build.VERSION_CODES.M)
    fun color(@ColorRes resId: Int): Int = activity.resources.getColor(resId, activity.theme)

}