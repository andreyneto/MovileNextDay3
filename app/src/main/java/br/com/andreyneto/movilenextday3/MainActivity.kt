package br.com.andreyneto.movilenextday3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.andreyneto.movilenextday3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding: ActivityMainBinding by contentView(R.layout.activity_main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        val game = Game("portal 2", 200, "https://reclaimer105.files.wordpress.com/2012/01/portal-2-e3-glados.png?w=490&h=283")
        binding.game = game
    }
}
