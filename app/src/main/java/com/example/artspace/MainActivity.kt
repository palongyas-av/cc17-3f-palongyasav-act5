package com.example.artspace

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

data class Artwork(
    val id: Int,
    val title: String,
    val artist: String,
    val year: Int,
    val imageResourceId: Int
)

class MainActivity : AppCompatActivity() {

    private var currentIndex = 0
    private val artworkList = listOf(
        Artwork(1, "Mona Lisa", "Leonardo da Vinci", 2021, R.drawable.art_1),
        Artwork(2, "The Last Supper", "JLeonardo da Vinci", 1495, R.drawable.art_2),
        Artwork(3, "The Starry Night", "Vincent van Gogh", 1889, R.drawable.art_3),
        Artwork(4, "Girl with a Pearl Earring", "Johannes Vermeer", 1665, R.drawable.art_4),
        Artwork(5, "The birth of Venus", "Sandro Botticelli", 1480, R.drawable.art_5),

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val artImageView = findViewById<ImageView>(R.id.imageView)
        val artTitleTextView = findViewById<TextView>(R.id.artTitle)
        val artistTextView = findViewById<TextView>(R.id.artistNameDate)
        val nextButton = findViewById<Button>(R.id.nextButton)
        val previewButton = findViewById<Button>(R.id.previewButton)

        @SuppressLint("SetTextI18n")
        fun updateArtworkDisplay() {
            val currentArtwork = artworkList[currentIndex]
            artImageView.setImageResource(currentArtwork.imageResourceId)
            artTitleTextView.text = currentArtwork.title
            "${currentArtwork.artist} (${currentArtwork.year})".also { artistTextView.text = it }
        }
        updateArtworkDisplay()
        nextButton.setOnClickListener {
            currentIndex++
            if (currentIndex >= artworkList.size) {
                currentIndex = 0
            }
            updateArtworkDisplay()
        }
        previewButton.setOnClickListener {
            currentIndex--
            if (currentIndex < 0) {
                currentIndex = artworkList.size - 1
            }
            updateArtworkDisplay()
        }
    }
}
