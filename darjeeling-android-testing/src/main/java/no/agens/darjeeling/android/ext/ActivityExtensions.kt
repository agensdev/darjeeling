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
import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.withFragment
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario

fun Activity.relativeLayout(@IdRes resId: Int): RelativeLayout = view(resId)
fun Fragment.relativeLayout(@IdRes resId: Int): RelativeLayout = view(resId)
inline fun <reified F : Fragment> FragmentScenario<F>.relativeLayout(
    @IdRes resId: Int): RelativeLayout = view(resId)

inline fun <reified A : Activity> ActivityScenario<A>.relativeLayout(
    @IdRes resId: Int): RelativeLayout = view(resId)

fun Activity.constraintLayout(@IdRes resId: Int): ConstraintLayout = view(resId)
fun Fragment.constraintLayout(@IdRes resId: Int): ConstraintLayout = view(resId)
inline fun <reified F : Fragment> FragmentScenario<F>.constraintLayout(
    @IdRes resId: Int): ConstraintLayout =
    view(resId)

inline fun <reified A : Activity> ActivityScenario<A>.constraintLayout(
    @IdRes resId: Int): ConstraintLayout =
    view(resId)

fun Activity.linearLayout(@IdRes resId: Int): LinearLayout = view(resId)
fun Fragment.linearLayout(@IdRes resId: Int): LinearLayout = view(resId)
inline fun <reified F : Fragment> FragmentScenario<F>.linearLayout(
    @IdRes resId: Int): LinearLayout = view(resId)

inline fun <reified A : Activity> ActivityScenario<A>.linearLayout(
    @IdRes resId: Int): LinearLayout = view(resId)

fun Activity.cardView(@IdRes resId: Int): CardView = view(resId)
fun Fragment.cardView(@IdRes resId: Int): CardView = view(resId)
inline fun <reified F : Fragment> FragmentScenario<F>.cardView(@IdRes resId: Int): CardView =
    view(resId)

inline fun <reified A : Activity> ActivityScenario<A>.cardView(@IdRes resId: Int): CardView =
    view(resId)

fun Activity.progressBar(@IdRes resId: Int): ProgressBar = view(resId)
fun Fragment.progressBar(@IdRes resId: Int): ProgressBar = view(resId)
inline fun <reified F : Fragment> FragmentScenario<F>.progressBar(@IdRes resId: Int): ProgressBar =
    view(resId)

inline fun <reified A : Activity> ActivityScenario<A>.progressBar(@IdRes resId: Int): ProgressBar =
    view(resId)

fun Activity.editText(@IdRes resId: Int): EditText = view(resId)
fun Fragment.editText(@IdRes resId: Int): EditText = view(resId)
inline fun <reified F : Fragment> FragmentScenario<F>.editText(@IdRes resId: Int): EditText =
    view(resId)

inline fun <reified A : Activity> ActivityScenario<A>.editText(@IdRes resId: Int): EditText =
    view(resId)

fun Activity.textView(@IdRes resId: Int): TextView = view(resId)
fun Fragment.textView(@IdRes resId: Int): TextView = view(resId)
inline fun <reified F : Fragment> FragmentScenario<F>.textView(@IdRes resId: Int): TextView =
    view(resId)

inline fun <reified A : Activity> ActivityScenario<A>.textView(@IdRes resId: Int): TextView =
    view(resId)

fun Activity.button(@IdRes resId: Int): Button = view(resId)
fun Fragment.button(@IdRes resId: Int): Button = view(resId)
inline fun <reified F : Fragment> FragmentScenario<F>.button(@IdRes resId: Int): Button =
    view(resId)

inline fun <reified A : Activity> ActivityScenario<A>.button(@IdRes resId: Int): Button =
    view(resId)

fun Activity.imageButton(@IdRes resId: Int): ImageButton = view(resId)
fun Fragment.imageButton(@IdRes resId: Int): ImageButton = view(resId)
inline fun <reified F : Fragment> FragmentScenario<F>.imageButton(@IdRes resId: Int): ImageButton =
    view(resId)

inline fun <reified A : Activity> ActivityScenario<A>.imageButton(@IdRes resId: Int): ImageButton =
    view(resId)

fun Activity.imageView(@IdRes resId: Int): ImageView = view(resId)
fun Fragment.imageView(@IdRes resId: Int): ImageView = view(resId)
inline fun <reified F : Fragment> FragmentScenario<F>.imageView(@IdRes resId: Int): ImageView =
    view(resId)

inline fun <reified A : Activity> ActivityScenario<A>.imageView(@IdRes resId: Int): ImageView =
    view(resId)

fun Activity.checkBox(@IdRes resId: Int): CheckBox = view(resId)
fun Fragment.checkBox(@IdRes resId: Int): CheckBox = view(resId)
inline fun <reified F : Fragment> FragmentScenario<F>.checkBox(@IdRes resId: Int): CheckBox =
    view(resId)

inline fun <reified A : Activity> ActivityScenario<A>.checkBox(@IdRes resId: Int): CheckBox =
    view(resId)

fun Activity.recyclerView(@IdRes resId: Int): RecyclerView = view(resId)
fun Fragment.recyclerView(@IdRes resId: Int): RecyclerView = view(resId)
inline fun <reified F : Fragment> FragmentScenario<F>.recyclerView(
    @IdRes resId: Int): RecyclerView = view(resId)

inline fun <reified A : Activity> ActivityScenario<A>.recyclerView(
    @IdRes resId: Int): RecyclerView = view(resId)

fun <T : View> Activity.view(@IdRes resId: Int): T = this.findViewById(resId)
fun <T : View> Fragment.view(@IdRes resId: Int): T = this.requireActivity().findViewById(resId)
inline fun <T : View, reified F : Fragment> FragmentScenario<F>.view(@IdRes resId: Int): T =
    this.withFragment { this.requireActivity().findViewById(resId) }

fun <T : View, A : Activity> ActivityScenario<A>.view(@IdRes resId: Int): T {
    lateinit var view: T
    this.onActivity {
        view = it.view(resId)
    }
    return view
}

fun Activity.string(@StringRes stringResId: Int): String =
    this.resources.getString(stringResId)

fun Fragment.string(@StringRes stringResId: Int): String =
    this.resources.getString(stringResId)

inline fun <reified F : Fragment> FragmentScenario<F>.string(@StringRes stringResId: Int): String =
    withFragment { resources.getString(stringResId) }

inline fun <reified A : Activity> ActivityScenario<A>.string(@StringRes stringResId: Int): String {
    lateinit var string: String
    onActivity { string = it.resources.getString(stringResId) }
    return string
}

inline fun <reified F : Fragment> FragmentScenario<F>.string(@StringRes stringResId: Int,
    vararg formatArgs: Any): String =
    withFragment { resources.getString(stringResId, formatArgs) }

inline fun <reified A : Activity> ActivityScenario<A>.string(@StringRes stringResId: Int,
    vararg formatArgs: Any): String {
    lateinit var string: String
    onActivity { string = it.resources.getString(stringResId, formatArgs) }
    return string
}

fun Activity.drawable(@DrawableRes resId: Int): Drawable? =
    ResourcesCompat.getDrawable(this.resources, resId, this.theme)

fun Fragment.drawable(@DrawableRes resId: Int): Drawable? =
    ResourcesCompat.getDrawable(this.resources, resId, this.requireContext().theme)

inline fun <reified F : Fragment> FragmentScenario<F>.drawable(@DrawableRes resId: Int): Drawable? =
    withFragment { resources.getDrawable(resId, this.requireContext().theme) }

inline fun <reified A : Activity> ActivityScenario<A>.drawable(@DrawableRes resId: Int): Drawable? {
    var drawable: Drawable? = null
    onActivity { drawable = ResourcesCompat.getDrawable(it.resources, resId, it.theme) }
    return drawable
}

@RequiresApi(Build.VERSION_CODES.M)
fun Activity.color(@ColorRes resId: Int): Int = this.resources.getColor(resId, this.theme)

@RequiresApi(Build.VERSION_CODES.M)
fun Fragment.color(@ColorRes resId: Int): Int =
    this.resources.getColor(resId, this.requireContext().theme)

@RequiresApi(Build.VERSION_CODES.M)
inline fun <reified F : Fragment> FragmentScenario<F>.color(@ColorRes resId: Int): Int =
    withFragment { this.resources.getColor(resId, this.requireContext().theme) }

@RequiresApi(Build.VERSION_CODES.M)
inline fun <reified A : Activity> ActivityScenario<A>.color(@ColorRes resId: Int): Int {
    var color: Int = 0
    onActivity { color = it.resources.getColor(resId, it.theme) }
    return color
}
