package br.com.andreyneto.movilenextday3

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable

class Game(val name: String,
                val launchYear: Int,
                val imageUrl: String,
                rating: Double) : BaseObservable() {
    val isClassic = launchYear < 2000

    var rating = rating
        @Bindable get
        set(value) {
            if(field!=value) {
                field = value
                notifyPropertyChanged(BR.rating)
            }
        }
}