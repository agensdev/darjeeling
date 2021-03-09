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
import no.agens.darjeeling.android.ext.view

abstract class DarjeelingBase {

    abstract val activity: Activity

    @Deprecated(message = "Use extension methods for Activity and Fragment instead.")
    fun relativeLayout(@IdRes resId: Int): RelativeLayout = view(resId)

    @Deprecated(message = "Use extension methods for Activity and Fragment instead.")
    fun constraintLayout(@IdRes resId: Int): ConstraintLayout = view(resId)

    @Deprecated(message = "Use extension methods for Activity and Fragment instead.")
    fun linearLayout(@IdRes resId: Int): LinearLayout = view(resId)

    @Deprecated(message = "Use extension methods for Activity and Fragment instead.")
    fun cardView(@IdRes resId: Int): CardView = view(resId)

    @Deprecated(message = "Use extension methods for Activity and Fragment instead.")
    fun progressBar(@IdRes resId: Int): ProgressBar = view(resId)

    @Deprecated(message = "Use extension methods for Activity and Fragment instead.")
    fun editText(@IdRes resId: Int): EditText = view(resId)

    @Deprecated(message = "Use extension methods for Activity and Fragment instead.")
    fun textView(@IdRes resId: Int): TextView = view(resId)

    @Deprecated(message = "Use extension methods for Activity and Fragment instead.")
    fun button(@IdRes resId: Int): Button = view(resId)

    @Deprecated(message = "Use extension methods for Activity and Fragment instead.")
    fun imageButton(@IdRes resId: Int): ImageButton = view(resId)

    @Deprecated(message = "Use extension methods for Activity and Fragment instead.")
    fun imageView(@IdRes resId: Int): ImageView = view(resId)

    @Deprecated(message = "Use extension methods for Activity and Fragment instead.")
    fun checkBox(@IdRes resId: Int): CheckBox = view(resId)

    @Deprecated(message = "Use extension methods for Activity and Fragment instead.")
    fun recyclerView(@IdRes resId: Int): RecyclerView = view(resId)

    @Deprecated(message = "Use extension methods for Activity and Fragment instead.")
    fun <T : View> view(@IdRes resId: Int): T = activity.view(resId)

    @Deprecated(message = "Use extension methods for Activity and Fragment instead.")
    fun string(@StringRes stringResId: Int): String =
        activity.resources.getString(stringResId)

    @Deprecated(message = "Use extension methods for Activity and Fragment instead.")
    fun drawable(@DrawableRes resId: Int): Drawable = activity.resources.getDrawable(resId, activity.theme)

    @Deprecated(message = "Use extension methods for Activity and Fragment instead.")
    @RequiresApi(Build.VERSION_CODES.M)
    fun color(@ColorRes resId: Int): Int = activity.resources.getColor(resId, activity.theme)

}