package br.com.andreyneto.movilenextday3

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.andreyneto.movilenextday3.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val binding: ActivityMainBinding by contentView(R.layout.activity_main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        val game = Game("portal 2",
            2004,
            "https://reclaimer105.files.wordpress.com/2012/01/portal-2-e3-glados.png?w=490&h=283",
            5.5)
        binding.game = game
        tvRating.setOnClickListener {
            game.rating += 1
        }

        fabAdd.setOnClickListener {
            val intent = Intent(this, GameAddActivity::class.java)
            startActivity(intent)
        }

    }
}
