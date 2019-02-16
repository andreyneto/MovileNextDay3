package br.com.andreyneto.movilenextday3

import android.app.Activity
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import kotlin.reflect.KProperty

class SetContentView<out T : ViewDataBinding>(
    @LayoutRes
    private val layoutRes: Int
) {
    operator fun getValue(thisRef: Activity, property: KProperty<*>): T {
        return  DataBindingUtil.setContentView(thisRef, layoutRes)
    }
}