package br.com.andreyneto.movilenextday3

data class Game(val name: String,
                val launchYear: Int,
                val imageUrl: String) {
    val isClassic = launchYear < 2000
}