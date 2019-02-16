package br.com.andreyneto.movilenextday3

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.jakewharton.rxbinding2.widget.RxTextView
import io.reactivex.BackpressureStrategy
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.Flowables
import kotlinx.android.synthetic.main.activity_game_add.*

class GameAddActivity : AppCompatActivity() {

    private lateinit var disposable: Disposable

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_add)
        val nameChangeObservable = RxTextView
            .textChanges(etName)
            .skipInitialValue()
            .observeOn(AndroidSchedulers.mainThread())
            .toFlowable(BackpressureStrategy.LATEST)
        val yearChangeObservable = RxTextView
            .textChanges(etYear)
            .skipInitialValue()
            .observeOn(AndroidSchedulers.mainThread())
            .toFlowable(BackpressureStrategy.LATEST)
        disposable = Flowables.combineLatest(nameChangeObservable, yearChangeObservable) {
                newName: CharSequence, newYear: CharSequence ->
            val nameValid = newName.length > 4
            if(!nameValid) etName.error = "Invalid name"
            val yearValid = newName.length == 4
            if(!yearValid) etYear.error = "Invalid year"
            nameValid && yearValid
        }.subscribe {formValid->
            btAdd.setBackgroundColor(
                ContextCompat.getColor(applicationContext,
                    if (formValid) R.color.colorPrimaryDark else android.R.color.darker_gray))
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable.dispose()
    }
}
