package br.com.andreyneto.movilenextday3

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

object BindingAdapters {
    @JvmStatic @BindingAdapter("image")
    fun ImageView.loadImage(imageUrl: String?) {
        // Load image Logic
        Picasso.get().load(imageUrl).into(this)
    }
}