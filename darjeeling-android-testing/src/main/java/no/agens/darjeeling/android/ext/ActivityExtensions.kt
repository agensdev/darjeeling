package no.agens.darjeeling.android.ext

import android.app.Activity
import android.graphics.drawable.Drawable
import android.os.Build
import android.view.View
import android.widget.*
import androidx.annotation.*
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView

fun Activity.relativeLayout(@IdRes resId: Int): RelativeLayout = view(resId)
fun Fragment.relativeLayout(@IdRes resId: Int): RelativeLayout = view(resId)

fun Activity.constraintLayout(@IdRes resId: Int): ConstraintLayout = view(resId)
fun Fragment.constraintLayout(@IdRes resId: Int): ConstraintLayout = view(resId)

fun Activity.linearLayout(@IdRes resId: Int): LinearLayout = view(resId)
fun Fragment.linearLayout(@IdRes resId: Int): LinearLayout = view(resId)

fun Activity.cardView(@IdRes resId: Int): CardView = view(resId)
fun Fragment.cardView(@IdRes resId: Int): CardView = view(resId)

fun Activity.progressBar(@IdRes resId: Int): ProgressBar = view(resId)
fun Fragment.progressBar(@IdRes resId: Int): ProgressBar = view(resId)

fun Activity.editText(@IdRes resId: Int): EditText = view(resId)
fun Fragment.editText(@IdRes resId: Int): EditText = view(resId)

fun Activity.textView(@IdRes resId: Int): TextView = view(resId)
fun Fragment.textView(@IdRes resId: Int): TextView = view(resId)

fun Activity.button(@IdRes resId: Int): Button = view(resId)
fun Fragment.button(@IdRes resId: Int): Button = view(resId)

fun Activity.imageButton(@IdRes resId: Int): ImageButton = view(resId)
fun Fragment.imageButton(@IdRes resId: Int): ImageButton = view(resId)

fun Activity.imageView(@IdRes resId: Int): ImageView = view(resId)
fun Fragment.imageView(@IdRes resId: Int): ImageView = view(resId)

fun Activity.checkBox(@IdRes resId: Int): CheckBox = view(resId)
fun Fragment.checkBox(@IdRes resId: Int): CheckBox = view(resId)

fun Activity.recyclerView(@IdRes resId: Int): RecyclerView = view(resId)
fun Fragment.recyclerView(@IdRes resId: Int): RecyclerView = view(resId)

fun <T : View> Activity.view(@IdRes resId: Int): T = this.findViewById(resId)
fun <T : View> Fragment.view(@IdRes resId: Int): T = this.requireActivity().findViewById(resId)

fun Activity.string(@StringRes stringResId: Int): String =
    this.resources.getString(stringResId)

fun Fragment.string(@StringRes stringResId: Int): String =
    this.resources.getString(stringResId)

fun Activity.drawable(@DrawableRes resId: Int): Drawable? =
    ResourcesCompat.getDrawable(this.resources, resId, this.theme)

fun Fragment.drawable(@DrawableRes resId: Int): Drawable? =
    ResourcesCompat.getDrawable(this.resources, resId, this.requireContext().theme)

@RequiresApi(Build.VERSION_CODES.M)
fun Activity.color(@ColorRes resId: Int): Int = this.resources.getColor(resId, this.theme)

@RequiresApi(Build.VERSION_CODES.M)
fun Fragment.color(@ColorRes resId: Int): Int = this.resources.getColor(resId, this.requireContext().theme)